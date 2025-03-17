plugins {
    kotlin("jvm")
}

dependencies {
    implementation(project(":common"))
    implementation("org.apache.kafka:kafka-clients:3.4.0") // Kafka client
    implementation("org.jsoup:jsoup:1.15.3") // Web scraping
    implementation("org.apache.httpcomponents.client5:httpclient5:5.2") // HTTP requests
}
