package com.publicrecord.api

import io.dropwizard.Configuration
import com.fasterxml.jackson.annotation.JsonProperty
import javax.validation.constraints.NotEmpty

class AppConfig : Configuration() {
    @NotEmpty
    @JsonProperty("serviceName")
    var serviceName: String = "political-accountability-app"
}