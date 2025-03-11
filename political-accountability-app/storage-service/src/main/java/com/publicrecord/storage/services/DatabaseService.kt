package com.publicrecord.storage.services

import java.sql.Connection
import java.sql.DriverManager

class DatabaseService {
    private val connection: Connection = DriverManager.getConnection(
        "jdbc:postgresql://localhost:5432/political_db", "postgres", "password"
    )

    fun startService() {
        println("Starting database")
    }

    fun getConnection(): Connection {
        return connection
    }
}
