import com.javiersc.semver.project.gradle.plugin.LazyVersion
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.openapitools.generator.gradle.plugin.tasks.GenerateTask

plugins {
    id("spring-boot")

    id("com.rameshkp.openapi-merger-gradle-plugin")
    id("org.openapi.generator")
}

val specsDir = "$projectDir/src/main/resources/openapi/specs/"

if (File(specsDir).exists()) {
    openApiMerger {
        inputDirectory.set(File(specsDir))
        output {
            directory.set(File(specsDir))
            fileName.set("all-openapi")
            fileExtension.set("yaml")
        }
        openApi {
            openApiVersion.set("3.0.1")
            info {
                title.set("shopfloor-api")
                version.set((project.version as LazyVersion).toString())
            }
        }
    }

    val packageName = "org.example.api"

// https://github.com/OpenAPITools/openapi-generator/blob/master/docs/generators/kotlin.md
    val pluginProperties = mapOf(
        "title" to "shopfloor-api",
        "apiPackage" to packageName,
        "packageName" to packageName,
        "basePackage" to packageName,
        "modelPackage" to "$packageName.dto",
        "dateLibrary" to "java8",
        "exceptionHandler" to "true",
        "singleContentTypes" to "true",
        "interfaceOnly" to "true",
        "swaggerAnnotations" to "false",
        "library" to "spring-boot",
        "useSpringBoot3" to "true",
        "modelMutable" to "true",
        "idea" to "true",
        "nullableReturnType" to "true",
        "useCoroutines" to "false",
        "enumPropertyNaming" to "UPPERCASE",
        "useTags" to "",
    )

    tasks.register<GenerateTask>("all-openapi") {
        inputSpec.set("${specsDir}all-openapi.yaml")
        generatorName.set("kotlin-spring")
        outputDir.set("${project.buildDir.path}/generated")
        verbose.set(false)
        generateApiTests.set(false)
        generateModelTests.set(false)
        generateModelDocumentation.set(false)
        generateApiDocumentation.set(false)
        generateAliasAsModel.set(false)
        configOptions.set(pluginProperties)
    }

    tasks.named("mergeOpenApiFiles") {
        mustRunAfter("processResources")
    }

    tasks.named("all-openapi") {
        dependsOn("mergeOpenApiFiles") // creates implicit dependencies
        mustRunAfter("mergeOpenApiFiles") // controls the execution order
    }

    tasks.withType<KotlinCompile> {
        dependsOn("all-openapi")
        mustRunAfter("all-openapi")
    }

    sourceSets {
        main {
            kotlin {
                srcDirs("${project.buildDir.path}/generated/src/main/kotlin")
                exclude("ch/**/ApiUtil*")
            }
        }
    }

// this is a fix because the swaggerAnnotations=false seems to not work
    val swaggerVersion = "2.2.4"
    val swaggerGroup = "io.swagger.core.v3"
    dependencies {
        implementation(group = swaggerGroup, name = "swagger-annotations", version = swaggerVersion)
        implementation(group = swaggerGroup, name = "swagger-models", version = swaggerVersion)
    }
}