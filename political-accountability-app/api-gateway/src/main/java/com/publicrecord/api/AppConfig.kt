package com.publicrecord.api

import io.dropwizard.Configuration

class AppConfig: Configuration() {
    var database: DatabaseConfig = DatabaseConfig()
}

class DatabaseConfig {
    var url: String = "jdbc:postgresql://localhost:5432/political_db"
    var user: String = "postgres"
    var password: String = "password"
}