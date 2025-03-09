package com.publicrecord.api.resources

import javax.ws.rs.*
import javax.ws.rs.core.MediaType
//import com.publicrecord.storage.DatabaseService
//import com.publicrecord.common.models.Politician

@Path("/politicians")
@Produces(MediaType.APPLICATION_JSON)
class PoliticianResource {

//    @GET
//    @Path("/{id}")
//    fun getPolitician(@PathParam("id") id: String): Politician? {
//        return DatabaseService.getPoliticianById(id) ?: throw NotFoundException("Politician not found")
//    }
}
