import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.openapitools.generator.gradle.plugin.tasks.GenerateTask

plugins {
    id("spring-boot")
    id("org.openapi.generator")
}

val packageName = "ch.brw.hive.shopfloor.api"

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

File("$projectDir/src/main/resources/openapi/specs/")
    .walk().filter { it.isFile }.forEach { createApiGeneratorTask(it) }

fun createApiGeneratorTask(apiSpec: File) {
    tasks.register<GenerateTask>(apiSpec.nameWithoutExtension) {
        inputSpec.set(apiSpec.toString())
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
    tasks.withType<KotlinCompile> {
        dependsOn(apiSpec.nameWithoutExtension)
    }
}

sourceSets {
    main {
        kotlin {
            srcDirs("${project.buildDir.path}/generated/src/main/kotlin")
            exclude("ch/**/ApiUtil.kt")
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
