package com.publicrecord.common.models

import java.time.LocalDateTime
import java.util.UUID

data class MediaFile(
    val id: UUID,
    val policianId: UUID?,
    val fileType: String,
    val title: String,
    val source: String,
    val publishedDate: LocalDateTime,
    val storageUrl: String,
    val transcript: String,
    val tags: List<String>,
)
