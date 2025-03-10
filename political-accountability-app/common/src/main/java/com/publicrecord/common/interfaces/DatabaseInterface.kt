package com.publicrecord.common.interfaces

import com.publicrecord.common.models.Politician
import java.util.UUID

interface DatabaseInterface {

    fun getPoliticianById(id: UUID): Politician?

}