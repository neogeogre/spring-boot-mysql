plugins {
    id("jib")
}

//val springCloudVersion = "2022.0.3"
//val springCloudKubernetesVersion = "3.0.3"
//dependencyManagement {
//    imports {
//        mavenBom("org.springframework.cloud:spring-cloud-dependencies:$springCloudVersion")
//    }
//}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-json")
    implementation("org.springframework.boot:spring-boot-starter-oauth2-resource-server")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")

//    implementation("org.springframework.cloud:spring-cloud-kubernetes-dependencies:$springCloudKubernetesVersion")
//    implementation("org.springframework.cloud:spring-cloud-starter-kubernetes-client")
//    implementation("org.springframework.cloud:spring-cloud-starter-kubernetes-client-config")
//    implementation("org.springframework.cloud:spring-cloud-starter-kubernetes-client-all")
//    implementation("org.springframework.cloud:spring-cloud-starter-kubernetes-discoveryclient")

}

