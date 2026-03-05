package dev.carlosalbertojr.msusers.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.carlosalbertojr.msusers.infrastructure.persistence.entity.UserEntity;

public interface UserJpaRepository extends JpaRepository<UserEntity, String> {
    
}
