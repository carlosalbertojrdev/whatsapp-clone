package dev.carlosalbertojr.msusers.domain.users.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Getter;

@Getter
public class UserDomain {

    private String id;
    private String name;
    private String email;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public UserDomain(String id, String name, String email, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static UserDomain build(String name, String email) {
        return new UserDomain(UUID.randomUUID().toString(), name, email, LocalDateTime.now(), LocalDateTime.now());
    }
    
}
