package com.publicrecord.api

import io.dropwizard.Configuration
import com.fasterxml.jackson.annotation.JsonProperty
import javax.validation.constraints.NotEmpty

class AppConfig : Configuration() {
    @NotEmpty
    @JsonProperty("serviceName")
    var serviceName: String = "political-accountability-app"

    @JsonProperty("databaseUrl")
    var databaseUrl: String = "jdbc:postgresql://postgres:5432/political_data"

    @JsonProperty("databaseUser")
    var databaseUser: String = "postgres"

    @JsonProperty("databasePassword")
    var databasePassword: String = "postgres"

    @JsonProperty("databaseDriverClass")
    var databaseDriverClass: String = "org.postgresql.Driver"

    @JsonProperty("databaseMaxConnections")
    var databaseMaxConnections: Int = 10

    @JsonProperty("elasticsearchHost")
    var elasticsearchHost: String = "http://elasticsearch:9200"

    @JsonProperty("kafkaBootstrapServers")
    var kafkaBootstrapServers: String = "kafka:9092"

    @JsonProperty("minioEndpoint")
    var minioEndpoint: String = "http://minio:9000"

    @JsonProperty("minioAccessKey")
    var minioAccessKey: String = "minioadmin"

    @JsonProperty("minioSecretKey")
    var minioSecretKey: String = "minioadmin"

    @JsonProperty("minioBucket")
    var minioBucket: String = "political-media"

    @JsonProperty("cors")
    var cors: CorsConfig = CorsConfig()  // New nested CORS configuration
}
