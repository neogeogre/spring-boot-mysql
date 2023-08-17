plugins {
    `kotlin-dsl` // https://plugins.gradle.org/plugin/org.gradle.kotlin.kotlin-dsl
}

val kotlinVersion: String by project

val springBootVersion: String by project
val springDependencyManagementVersion: String by project

val semverVersion: String by project
val openapiMergerVersion: String by project
val openapiGeneratorVersion: String by project
val dockerComposeVersion: String by project
val jibVersion: String by project

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
    implementation("org.jetbrains.kotlin:kotlin-allopen:$kotlinVersion")
    implementation("org.jetbrains.kotlin:kotlin-noarg:$kotlinVersion")

    implementation("org.springframework.boot:spring-boot-gradle-plugin:$springBootVersion")
    implementation("io.spring.gradle:dependency-management-plugin:$springDependencyManagementVersion")

    implementation("com.javiersc.semver:semver-gradle-plugin:$semverVersion")
    implementation("com.rameshkp:openapi-merger-gradle-plugin:$openapiMergerVersion")
    implementation("org.openapitools:openapi-generator-gradle-plugin:$openapiGeneratorVersion")
    implementation("com.avast.gradle:gradle-docker-compose-plugin:$dockerComposeVersion")
    implementation("com.google.cloud.tools:jib-gradle-plugin:$jibVersion")
}
