package com.publicrecord.api

import io.dropwizard.Application
import io.dropwizard.setup.Environment
import com.publicrecord.api.resources.PoliticianResource
import com.publicrecord.api.resources.NewsResource
import com.publicrecord.api.resources.BillResource
import com.publicrecord.api.resources.MediaResource
import com.publicrecord.storage.services.DatabaseService
import com.publicrecord.storage.services.ElasticSearchService
import com.publicrecord.storage.services.MinIOService
import com.publicrecord.storage.services.KafkaService
import com.publicrecord.storage.managed.DatabaseManagedService
import com.publicrecord.storage.managed.ElasticSearchManagedService
import com.publicrecord.storage.managed.MinIOManagedService
import com.publicrecord.storage.managed.KafkaManagedService

class App : Application<AppConfig>() {
    override fun run(config: AppConfig, env: Environment) {

        println("Starting Dropwizard API...")

        // Instantiate backend services (could be configured with AppConfig in a real-world scenario)
        val databaseService = DatabaseService()
        val elasticSearchService = ElasticSearchService()
        val minioService = MinIOService()
        val kafkaService = KafkaService()

        // Register managed services with Dropwizard lifecycle
        env.lifecycle().manage(DatabaseManagedService(databaseService))
        env.lifecycle().manage(ElasticSearchManagedService(elasticSearchService))
        env.lifecycle().manage(MinIOManagedService(minioService))
        env.lifecycle().manage(KafkaManagedService(kafkaService))

        // Register API resources (which might later be injected with service addresses, etc.)
        env.jersey().register(PoliticianResource())
        env.jersey().register(NewsResource())
        env.jersey().register(BillResource())
        env.jersey().register(MediaResource())

        println("Dropwizard API started successfully!")
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            App().run("server", "api-gateway/src/main/resources/config.yml")
        }
    }
}
