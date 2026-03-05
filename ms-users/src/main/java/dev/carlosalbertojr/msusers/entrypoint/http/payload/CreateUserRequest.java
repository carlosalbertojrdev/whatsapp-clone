package dev.carlosalbertojr.msusers.entrypoint.http.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public record CreateUserRequest(
    @NotEmpty String name, 
    @Email String email
) {}
