package org.acme.resource;

import org.acme.dto.UserDTO;
import org.acme.service.UserService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/api/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "Usuarios", description = "Operaciones CRUD de usuarios")
public class UserResource {

    @Inject
    UserService userService;

    @GET
    @Operation(summary = "Listar todos los usuarios", description = "Retorna una lista de todos los usuarios registrados en el sistema")
    @APIResponse(responseCode = "200", description = "Lista obtenida con éxito")
    public List<UserDTO> list() {
        return userService.getAllUsers();
    }

    @POST
    @Operation(summary = "Crear un nuevo usuario", description = "Registra un usuario y le asigna un UUID único")
    @APIResponse(responseCode = "201", description = "Usuario creado",
            content = @Content(schema = @Schema(implementation = UserDTO.class)))
    public Response create(UserDTO user) {
        UserDTO createdUser = userService.createUser(user);
        return Response.status(Response.Status.CREATED).entity(createdUser).build();
    }
}