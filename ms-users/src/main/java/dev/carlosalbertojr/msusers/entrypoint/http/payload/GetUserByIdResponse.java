package dev.carlosalbertojr.msusers.entrypoint.http.payload;

import java.time.LocalDateTime;


public record GetUserByIdResponse(
        String id,
        String name,
        String email,
        LocalDateTime createdAt
) { }
