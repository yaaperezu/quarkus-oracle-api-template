package org.acme.dto;

import java.util.UUID;

public record UserDTO(UUID id, String username, String email, String role) {
    // Los records generan automáticamente constructor, getters, equals y hashCode.
}