package com.publicrecord.common.models

import java.time.LocalDateTime
import java.util.UUID

data class Bill(
    val id: UUID = UUID.randomUUID(),
    val billNumber: String,
    val title: String,
    val description: String,
    val introducedBy: UUID?,
    val status: String,
    val introducedDate: LocalDateTime,
    val lastActionDate: LocalDateTime,
    val billUrl: String,
)
