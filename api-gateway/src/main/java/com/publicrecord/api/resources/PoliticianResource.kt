package com.publicrecord.api.resources

import javax.ws.rs.*
import javax.ws.rs.core.MediaType
import com.publicrecord.common.models.Politician
import com.publicrecord.storage.repositories.PoliticianRepository
import com.publicrecord.api.StorageServiceClient

@Path("/politicians")
@Produces(MediaType.APPLICATION_JSON)
class PoliticianResource {

    private val storageServiceClient = StorageServiceClient()

    @GET
    @Path("/{id}")
    fun getPolitician(@PathParam("id") id: String): Politician? {
        return PoliticianRepository.getPoliticianById(id) ?: throw NotFoundException("Politician not found")
    }
}
