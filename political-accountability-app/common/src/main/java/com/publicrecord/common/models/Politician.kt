package com.publicrecord.common.models

import java.time.LocalDate
import java.util.UUID


data class Politician (
    val id: UUID,
    val firstName: String,
    val lastName: String,
    val party: String,
    val state: String,
    val office: String,
    val biography: String?,
    val profileImageUrl: String?,
    val startDate: LocalDate,
    val endDate: LocalDate?,

    )