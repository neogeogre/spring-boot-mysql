rootProject.name = "spring-boot-mysql"

include("lib")
include("app")

pluginManagement {
    repositories.gradlePluginPortal()
    includeBuild("gradle/plugins")
}
