package com.publicrecord.storage.managed

import io.dropwizard.lifecycle.Managed
import com.publicrecord.storage.services.DatabaseService
import org.slf4j.LoggerFactory

class DatabaseManagedService(private val databaseService: DatabaseService) : Managed {
    private val logger = LoggerFactory.getLogger(DatabaseManagedService::class.java)

    override fun start() {
        logger.info("Starting Database Service...")
        databaseService.startService()
        logger.info("Database Service started successfully.")
    }

    override fun stop() {
        logger.info("Stopping Database Service...")
        // If your DatabaseService has a close method, call it here.
        logger.info("Database Service stopped successfully.")
    }
}
