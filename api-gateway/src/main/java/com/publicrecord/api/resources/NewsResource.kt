package com.publicrecord.api.resources

import javax.ws.rs.*
import javax.ws.rs.core.MediaType
import com.publicrecord.common.models.NewsArticle
import com.publicrecord.storage.services.ElasticSearchService
import org.slf4j.LoggerFactory
import javax.ws.rs.core.Response

@Path("/news")
@Produces(MediaType.APPLICATION_JSON)
class NewsResource {

    private val logger = LoggerFactory.getLogger(NewsResource::class.java)
    private val elasticSearchService = ElasticSearchService()

    /**
     * Search news articles by a given keyword.
     * Example: GET /news/search?keyword=election
     */
    @GET
    @Path("/search")
    fun searchNews(@QueryParam("keyword") keyword: String?): Response {
        if (keyword.isNullOrBlank()) {
            logger.error("Keyword parameter is missing for news search.")
            return Response.status(Response.Status.BAD_REQUEST)
                .entity("Keyword query parameter is required.")
                .build()
        }
        logger.info("Searching news articles for keyword: $keyword")
        val articles: List<NewsArticle> = elasticSearchService.searchArticlesByKeyword(keyword)
        return Response.ok(articles).build()
    }

    /**
     * Retrieve a specific news article by its ID.
     * Example: GET /news/{id}
     */
    @GET
    @Path("/{id}")
    fun getNewsArticle(@PathParam("id") id: String): Response {
        logger.info("Fetching news article with ID: $id")
        // For a real application, implement a getById method in ElasticSearchService.
        // Here, we'll simulate by searching and picking the first match.
        val articles: List<NewsArticle> = elasticSearchService.searchArticlesByKeyword(id)
        val article = articles.firstOrNull()
        return if (article != null) {
            Response.ok(article).build()
        } else {
            logger.error("News article not found for ID: $id")
            Response.status(Response.Status.NOT_FOUND)
                .entity("News article not found.")
                .build()
        }
    }
}
