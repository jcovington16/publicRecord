package com.publicrecord.common.models

import java.time.LocalDateTime
import java.util.UUID

data class NewsArticle(
    val id: UUID = UUID.randomUUID(),
    val politicianId: UUID?,
    val title: String,
    val source: String,
    val publishedDate: LocalDateTime,
    val url: String,
    val content: String,
)
