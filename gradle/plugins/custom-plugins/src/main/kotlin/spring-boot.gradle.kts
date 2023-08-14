plugins {
    id("common-plugins")

    kotlin("plugin.spring") // id("org.jetbrains.kotlin.plugin.spring")

    id("org.springframework.boot")
    id("io.spring.dependency-management")

    id("org.jetbrains.kotlin.plugin.allopen")
    id("org.jetbrains.kotlin.plugin.jpa")
}

springBoot {
    buildInfo()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-security")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.security:spring-security-test")
}

