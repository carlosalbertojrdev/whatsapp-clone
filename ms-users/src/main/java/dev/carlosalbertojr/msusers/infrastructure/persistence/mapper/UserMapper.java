package dev.carlosalbertojr.msusers.infrastructure.persistence.mapper;

import dev.carlosalbertojr.msusers.domain.users.entity.UserDomain;
import dev.carlosalbertojr.msusers.infrastructure.persistence.entity.UserEntity;

public class UserMapper {
    
    public static UserDomain mapToDomain(UserEntity entity) {
        return new UserDomain(
            entity.getId(), 
            entity.getName(), 
            entity.getEmail(), 
            entity.getCreatedAt(), 
            entity.getUpdatedAt());
    };

    public static UserEntity mapToEntity(UserDomain domain) {
        return new UserEntity(
            domain.getId(), 
            domain.getName(), 
            domain.getEmail(), 
            domain.getCreatedAt(), 
            domain.getUpdatedAt()
        );
    }
}
