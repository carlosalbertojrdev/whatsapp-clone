package dev.carlosalbertojr.msusers.domain.users.service;

import java.util.Optional;

import dev.carlosalbertojr.msusers.domain.shared.DomainException;
import dev.carlosalbertojr.msusers.domain.shared.DomainService;
import dev.carlosalbertojr.msusers.domain.users.entity.UserDomain;
import dev.carlosalbertojr.msusers.domain.users.repository.UserRepository;
import dev.carlosalbertojr.msusers.domain.users.service.dto.CreateUserInput;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class CreateUserService implements DomainService<CreateUserInput, UserDomain> {
    
    private final UserRepository userRepository;

    @Override
    public Optional<UserDomain> execute(CreateUserInput input) {
        log.info("[CreateUserService] Saving user...");

        final var saved = userRepository.save(UserDomain.build(input.name(), input.email()))
                            .orElseThrow(() -> new DomainException("Error to save user"));

        log.info("[CreateUserService] User was saved successfully: " + saved.getId());            

        return Optional.of(saved);
    }

}
