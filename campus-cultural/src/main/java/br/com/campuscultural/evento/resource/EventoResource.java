package br.com.campuscultural.evento.resource;

import java.util.UUID;

import br.com.campuscultural.evento.controller.EventoController;
import br.com.campuscultural.evento.dto.EventoDto;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/evento")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EventoResource {

    @Inject
    EventoController eventoController;

    @POST
    public Response create(EventoDto eventoDto) {
        return Response.ok().entity(eventoController.create(eventoDto)).build();
    }

    @GET
    @Path("{id}")
    public Response retrieveById(@PathParam("id") String uuid) {
        return Response.ok().entity(eventoController.retrieve(UUID.fromString(uuid))).build();
    }

    @GET
    public Response retrieveAll() {
        return Response.ok().entity(eventoController.retrieveAll()).build();
    }

    @GET
    @Path("usuario/{id}")
    public Response retrieveByUserId(@PathParam("id") String uuid) {
        return Response.ok().entity(eventoController.retrieveByUserId(UUID.fromString(uuid))).build();
    }

    @PUT
    public Response update(EventoDto eventoDto) {
        return Response.ok().entity(eventoController.update(eventoDto)).build();
    }
}
