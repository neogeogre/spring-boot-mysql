plugins {
    id("spring-boot")
    id("com.avast.gradle.docker-compose")
}

dockerCompose {
    useComposeFiles.set(listOf("$projectDir/src/test/docker/docker-compose.yaml"))
    isRequiredBy(tasks.getByName("test"))
}
