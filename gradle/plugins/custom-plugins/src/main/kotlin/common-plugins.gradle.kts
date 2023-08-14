import com.javiersc.semver.project.gradle.plugin.LazyVersion

plugins {
    id("kotlin-base")
    `maven-publish`

    id("project-report")
    id("com.javiersc.semver")
}

repositories {
    maven {
        url = uri("https://nexus.stemys.ch/repository/stemysplatform/")
        credentials {
            username = System.getenv("NEXUS_USERNAME")
            password = System.getenv("NEXUS_PASSWORD")
        }
    }
    maven {
        url = uri("https://nexus.stemys.ch/repository/nexus-stemys/")
        credentials {
            username = System.getenv("NEXUS_USERNAME")
            password = System.getenv("NEXUS_PASSWORD")
        }
    }
    mavenCentral()
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            groupId = project.group as String
            artifactId = project.name
            version = (project.version as LazyVersion).toString()
            from(components["java"])
        }
    }
    repositories {
        maven {
            val theVersion = (project.version as LazyVersion).toString()
            val nexusRepoUrl = when(theVersion.lowercase().endsWith("snapshot")) {
                true -> "https://nexus.stemys.ch/repository/maven-snapshots/"
                false -> "https://nexus.stemys.ch/repository/maven-releases/"
            }
            url = uri(nexusRepoUrl)
            credentials {
                username = System.getenv("NEXUS_USERNAME")
                password = System.getenv("NEXUS_PASSWORD")
            }
        }
    }
}

semver {
    tagPrefix.set("")
}
