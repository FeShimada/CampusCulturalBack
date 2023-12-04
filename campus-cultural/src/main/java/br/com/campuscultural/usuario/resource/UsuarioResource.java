package br.com.campuscultural.usuario.resource;

import java.util.UUID;

import br.com.campuscultural.usuario.controller.UsuarioController;
import br.com.campuscultural.usuario.dto.LoginDto;
import br.com.campuscultural.usuario.dto.UsuarioDto;
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

@Path("/usuario")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UsuarioResource {

    @Inject
    UsuarioController usuarioController;

    @POST
    public Response create(UsuarioDto usuarioDto) {
        return Response.ok().entity(usuarioController.create(usuarioDto)).build();
    }

    @GET
    @Path("{id}")
    public Response retrieveById(@PathParam("id") String uuid) {
        return Response.ok().entity(usuarioController.retrieve(UUID.fromString(uuid))).build();
    }

    @GET
    public Response retrieveAll() {
        return Response.ok().entity(usuarioController.retrieveAll()).build();
    }

    @PUT
    public Response update(UsuarioDto usuarioDto) {
        return Response.ok().entity(usuarioController.update(usuarioDto)).build();
    }

    @POST
    @Path("login")
    public Response login(LoginDto loginDto) {
        return Response.ok().entity(usuarioController.login(loginDto)).build();
    }
}
