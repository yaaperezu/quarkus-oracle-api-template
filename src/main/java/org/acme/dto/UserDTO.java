package org.acme.dto;

import org.eclipse.microprofile.openapi.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Schema(name = "UserDTO", description = "Representación de los datos del usuario")
public record UserDTO(

        @Schema(description = "Identificador único del usuario (Generado por Oracle)", example = "1", readOnly = true)
        Long id,

        @Schema(description = "Nombre de cuenta único para el acceso al sistema", example = "yasser_perez")
        @NotBlank(message = "El nombre de usuario no puede estar vacío")
        @Size(min = 3, max = 20)
        String username,

        @Schema(description = "Dirección de correo electrónico institucional", example = "yasser@keralty.com")
        @NotBlank(message = "El email es obligatorio")
        @Email
        String email,

        @Schema(description = "Rol asignado dentro de la aplicación", example = "ADMIN", enumeration = {"ADMIN", "USER", "LEAD"})
        @NotBlank(message = "El rol es obligatorio")
        String role
) {
}