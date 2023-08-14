import com.javiersc.semver.project.gradle.plugin.LazyVersion

plugins {
    id("docker-compose")
    id("com.google.cloud.tools.jib")
}

jib {
    from {
        image = "openjdk:17-alpine"
    }
    to {
        val theVersion = (project.version as LazyVersion).toString()
        image = "stemysio/${project.name.lowercase()}:${theVersion}"
        auth {
            username = System.getenv("DOCKERHUB_USERNAME")
            password = System.getenv("DOCKERHUB_PASSWORD")
        }
        val extraTag = when(theVersion.lowercase().endsWith("snapshot")) {
            true -> "unstable"
            false -> "latest"
        }
        tags = setOf(extraTag)
    }
    container {
        ports = listOf("8080")
        creationTime.set("USE_CURRENT_TIMESTAMP")
    }
}