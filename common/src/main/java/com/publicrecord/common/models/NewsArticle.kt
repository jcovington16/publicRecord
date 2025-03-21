package com.publicrecord.common.models

import java.time.LocalDateTime
import java.util.UUID

data class NewsArticle(
    val id: UUID = UUID.randomUUID(),
    val politicianId: UUID?,         // ID of the politician this article is about
    val title: String,               // Title of the article
    val source: String,              // News source (e.g., CNN, BBC)
    val publishedDate: LocalDateTime, // When the article was published
    val url: String,                 // URL to the full article
    val content: String              // The full content (or an excerpt) of the article
)
