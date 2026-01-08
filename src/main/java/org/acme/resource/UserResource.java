package org.acme.resource;

import org.acme.dto.UserDTO;
import org.acme.service.UserService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/api/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "Usuarios", description = "Operaciones de usuarios")
public class UserResource {

    @Inject
    UserService userService;

    @GET
    @Operation(summary = "Listar usuarios")
    public List<UserDTO> list() {
        return userService.getAllUsers();
    }

    @POST
    @Operation(summary = "Crear usuario")
    public Response create(UserDTO userDTO) {
        UserDTO created = userService.createUser(userDTO);
        return Response.status(Response.Status.CREATED).entity(created).build();
    }
}