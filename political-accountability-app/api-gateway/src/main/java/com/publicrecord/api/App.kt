package com.publicrecord.api

import io.dropwizard.Application
import io.dropwizard.setup.Environment
import com.publicrecord.api.resources.PoliticianResource

class App : Application<AppConfig>() {
    override fun run(config: AppConfig, env: Environment) {
        env.jersey().register(PoliticianResource())
        println("Dropwizard API started successfully!")
    }
}

fun main(args: Array<String>) {
    App().run("server", "config.yml")
}
