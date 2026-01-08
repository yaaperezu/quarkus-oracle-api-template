package org.acme.resource;

import org.acme.entity.UserEntity;
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
@Tag(name = "Usuarios", description = "Operaciones persistidas en Oracle 21c")
public class UserResource {

    @Inject
    UserService userService;

    @GET
    @Operation(summary = "Listar usuarios desde Oracle")
    public List<UserEntity> list() {
        // Ahora llama al servicio que hace UserEntity.listAll()
        return userService.getAllUsers();
    }

    @POST
    @Operation(summary = "Persistir un nuevo usuario")
    public Response create(UserEntity user) {
        // El servicio se encarga de user.persist() y la transacción
        UserEntity createdUser = userService.createUser(user);
        return Response.status(Response.Status.CREATED).entity(createdUser).build();
    }
}