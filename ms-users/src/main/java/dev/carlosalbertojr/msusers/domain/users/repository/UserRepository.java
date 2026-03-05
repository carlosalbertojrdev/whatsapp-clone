package dev.carlosalbertojr.msusers.domain.users.repository;

import java.util.Optional;

import dev.carlosalbertojr.msusers.domain.users.entity.UserDomain;

public interface UserRepository {

    Optional<UserDomain> save(UserDomain user);
    
}
