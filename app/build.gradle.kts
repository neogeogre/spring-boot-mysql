plugins {
    id("spring-boot-app")
}

dependencies {
    implementation("org.mariadb.jdbc:mariadb-java-client:3.1.4")
    implementation(libs.liquibase)

}
