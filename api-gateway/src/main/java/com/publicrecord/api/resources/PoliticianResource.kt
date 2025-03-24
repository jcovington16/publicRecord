package com.publicrecord.api.resources

import com.publicrecord.api.StorageServiceClient
import javax.ws.rs.*
import javax.ws.rs.core.MediaType
import com.publicrecord.common.models.Politician
import javax.ws.rs.core.Response

@Path("/politicians")
@Produces(MediaType.APPLICATION_JSON)
class PoliticianResource {

    private val storageServiceClient = StorageServiceClient()

    @GET
    @Path("/{id}")
    fun getPolitician(@PathParam("id") id: String): Response {
        val politician = storageServiceClient.fetchPoliticianById(id)
        return if (politician != null) {
            Response.ok(politician).build()
        } else {
            Response.status(Response.Status.NOT_FOUND)
                .entity("Politician not found").build()
        }
    }
}
