package com.publicrecord.storage.managed

import io.dropwizard.lifecycle.Managed
import com.publicrecord.storage.services.ElasticSearchService
import org.slf4j.LoggerFactory

class ElasticSearchManagedService(private val esService: ElasticSearchService) : Managed {
    private val logger = LoggerFactory.getLogger(ElasticSearchManagedService::class.java)

    override fun start() {
        logger.info("Starting Elasticsearch Service...")
        // If your ElasticSearchService has initialization logic, call it here.
        logger.info("Elasticsearch Service started successfully.")
    }

    override fun stop() {
        logger.info("Stopping Elasticsearch Service...")
        esService.close()
        logger.info("Elasticsearch Service stopped successfully.")
    }
}
