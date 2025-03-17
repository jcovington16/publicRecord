plugins {
    kotlin("jvm")
    id("java") // ✅ Added to ensure Java dependencies work
}

dependencies {
    implementation(project(":common"))
    implementation(project(":storage-service"))
    implementation(project(":event-streaming"))

    // Dropwizard dependencies
    implementation("io.dropwizard:dropwizard-core:2.1.4")
    implementation("io.dropwizard:dropwizard-client:2.1.4")
    implementation("io.dropwizard:dropwizard-auth:2.1.4")
    implementation("io.dropwizard:dropwizard-assets:2.1.4")

    // PostgreSQL JDBC Driver
    implementation("org.postgresql:postgresql:42.5.1")

    // Kotlin SQL ORM (Exposed)
    implementation("org.jetbrains.exposed:exposed-core:0.41.1")
    implementation("org.jetbrains.exposed:exposed-dao:0.41.1")
    implementation("org.jetbrains.exposed:exposed-jdbc:0.41.1")

    // Elasticsearch Java Client
    implementation("co.elastic.clients:elasticsearch-java:8.6.2")
    implementation("org.apache.httpcomponents.client5:httpclient5:5.2")

    // MinIO Client (S3-Compatible)
    implementation("io.minio:minio:8.5.7")

    // Kafka Dependencies
    implementation("org.apache.kafka:kafka-clients:3.3.1")

    // ✅ Add Kafka Streams if Needed
    implementation("org.apache.kafka:kafka-streams:3.3.1")

    // Logging
    implementation("ch.qos.logback:logback-classic:1.2.11")

    // Testing
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.1")
}