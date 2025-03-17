package com.publicrecord.api

import com.publicrecord.common.models.Politician
import khttp.get

class StorageServiceClient {
    private val baseUrl = "http://storage-service:8082"

    fun fetchPoliticianById(id: String): Politician? {
        val response = get("$baseUrl/politicians/$id")
        return if (response.statusCode == 200) response.jsonObject.toPolitician() else null
    }
}
