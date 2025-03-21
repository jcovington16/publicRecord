package com.publicrecord.storage.services

import co.elastic.clients.elasticsearch.ElasticsearchClient
import co.elastic.clients.elasticsearch._types.query_dsl.MatchQuery
import co.elastic.clients.elasticsearch.core.IndexRequest
import co.elastic.clients.elasticsearch.core.SearchRequest
import co.elastic.clients.elasticsearch.core.SearchResponse
import co.elastic.clients.elasticsearch.core.search.Hit
import co.elastic.clients.transport.rest_client.RestClientTransport
import co.elastic.clients.json.jackson.JacksonJsonpMapper
import org.apache.http.HttpHost
import org.elasticsearch.client.RestClient
import org.slf4j.LoggerFactory
import com.publicrecord.common.models.NewsArticle

class ElasticSearchService {

    private val logger = LoggerFactory.getLogger(ElasticSearchService::class.java)

    private val client: ElasticsearchClient

    private val indexName = "news-articles"

    init {
        val restClient = RestClient.builder(HttpHost("elasticsearch", 9200)).build()
        val transport = RestClientTransport(restClient, JacksonJsonpMapper())
        client = ElasticsearchClient(transport)
        logger.info("✅ Elasticsearch service initialized and connected to $indexName index.")
    }

    /**
     * Index a news article into Elasticsearch
     */
    fun indexNewsArticle(article: NewsArticle): Boolean {
        return try {
            val request = IndexRequest.Builder<NewsArticle>()
                .index(indexName)
                .id(article.id.toString())
                .document(article)
                .build()

            client.index(request)
            logger.info("📥 Indexed article: ${article.title} (ID: ${article.id})")
            true
        } catch (e: Exception) {
            logger.error("❌ Failed to index article: ${article.title}. Error: ${e.message}")
            false
        }
    }

    /**
     * Search for articles by keyword
     */
    fun searchArticlesByKeyword(keyword: String): List<NewsArticle> {
        logger.info("🔎 Searching for articles with keyword: '$keyword'")
        return try {
            val searchRequest = SearchRequest.Builder()
                .index(indexName)
                .query { q -> q.match(MatchQuery.of { it.field("content").query(keyword) }) }
                .build()

            val response: SearchResponse<NewsArticle> = client.search(searchRequest, NewsArticle::class.java)

            val results = response.hits().hits().map(Hit<NewsArticle>::source).filterNotNull()
            logger.info("✅ Found ${results.size} articles matching keyword: '$keyword'")
            results
        } catch (e: Exception) {
            logger.error("❌ Search failed for keyword '$keyword': ${e.message}")
            emptyList()
        }
    }

    /**
     * Close the client gracefully
     */
    fun close() {
        try {
            client._transport().close()
            logger.info("🛑 Elasticsearch service connection closed.")
        } catch (e: Exception) {
            logger.warn("⚠️ Failed to close Elasticsearch client: ${e.message}")
        }
    }
}
