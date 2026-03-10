package dev.carlosalbertojr.msusers.infrastructure.persistence.repository.impl;

import java.util.Optional;

import dev.carlosalbertojr.msusers.domain.users.entity.UserDomain;
import dev.carlosalbertojr.msusers.domain.users.repository.UserRepository;
import dev.carlosalbertojr.msusers.infrastructure.persistence.mapper.UserMapper;
import dev.carlosalbertojr.msusers.infrastructure.persistence.repository.UserJpaRepository;

public class DefaultUserRepository implements UserRepository {

    private final UserJpaRepository userJpaRepository;

    public DefaultUserRepository(UserJpaRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }

    @Override
    public Optional<UserDomain> save(UserDomain user) {
        final var saved = userJpaRepository.save(UserMapper.mapToEntity(user));
        return Optional.of(UserMapper.mapToDomain(saved));
    }

    @Override
    public Optional<UserDomain> findById(String id) {
        return userJpaRepository.findById(id)
                .map(UserMapper::mapToDomain);
    }
}
