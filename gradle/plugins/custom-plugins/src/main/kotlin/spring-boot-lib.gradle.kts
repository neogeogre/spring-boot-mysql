import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    id("openapi-generator")
    `java-library`
}

// https://github.com/spring-projects/spring-boot/issues/10238#issuecomment-544227301
tasks.getByName<BootJar>("bootJar") {
    enabled = false
}

tasks.getByName<Jar>("jar") {
    enabled = true
}
