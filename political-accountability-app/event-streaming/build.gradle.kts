plugins {
    kotlin("jvm")
}

dependencies {
    implementation(project(":common"))
    implementation("org.apache.kafka:kafka-clients:3.4.0")
}
