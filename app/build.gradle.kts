plugins {
    id("spring-boot-app")
}

dependencies {
    implementation(libs.liquibase)
    implementation(libs.mariadb)
}
