package com.publicrecord.api

import io.dropwizard.Application
import io.dropwizard.setup.Environment
import com.publicrecord.api.resources.PoliticianResource
import com.publicrecord.api.resources.NewsResource
import com.publicrecord.api.resources.BillResource
import com.publicrecord.api.resources.MediaResource

class App : Application<AppConfig>() {
    override fun run(config: AppConfig, env: Environment) {
        println("Starting Dropwizard API...")

        // Register API resources
        env.jersey().register(PoliticianResource())
        env.jersey().register(NewsResource())
        env.jersey().register(BillResource())
        env.jersey().register(MediaResource())

        println("Dropwizard API started successfully!")
    }

    fun startServer() {
        run("server", "api-gateway/src/main/resources/config.yml")
    }
}
