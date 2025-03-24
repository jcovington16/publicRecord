package com.publicrecord.api

import com.fasterxml.jackson.annotation.JsonProperty

data class CorsConfig(
    @JsonProperty("allowedOrigins")
    var allowedOrigins: String = "*",
    @JsonProperty("allowedMethods")
    var allowedMethods: String = "OPTIONS,GET,PUT,POST,DELETE,HEAD",
    @JsonProperty("allowedHeaders")
    var allowedHeaders: String = "X-Requested-With,Content-Type,Accept,Origin"
)
