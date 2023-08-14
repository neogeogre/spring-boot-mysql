rootProject.name = "spring-boot-mysql"

include("app")

pluginManagement {
    repositories.gradlePluginPortal()
    includeBuild("gradle/plugins")
}
