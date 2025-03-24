package com.publicrecord.api

import com.publicrecord.common.models.Politician
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import okhttp3.OkHttpClient
import okhttp3.Request

class StorageServiceClient {
    private val baseUrl = "http://storage-service:8082"
    private val client = OkHttpClient()
    private val mapper = jacksonObjectMapper()

    fun fetchPoliticianById(id: String): Politician? {
        val request = Request.Builder()
            .url("$baseUrl/politicians/$id")
            .build()
        client.newCall(request).execute().use { response ->
            return if (response.isSuccessful) {
                val body = response.body?.string()
                if (body != null) {
                    mapper.readValue(body)
                } else null
            } else {
                null
            }
        }
    }
}
