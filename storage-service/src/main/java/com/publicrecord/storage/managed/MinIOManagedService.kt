package com.publicrecord.storage.managed

import io.dropwizard.lifecycle.Managed
import com.publicrecord.storage.services.MinIOService
import org.slf4j.LoggerFactory

class MinIOManagedService(private val minioService: MinIOService) : Managed {
    private val logger = LoggerFactory.getLogger(MinIOManagedService::class.java)

    override fun start() {
        logger.info("Starting MinIO Service...")
        minioService.startService()
        logger.info("MinIO Service started successfully.")
    }

    override fun stop() {
        logger.info("Stopping MinIO Service...")
        // Add any cleanup if needed
        logger.info("MinIO Service stopped successfully.")
    }
}
