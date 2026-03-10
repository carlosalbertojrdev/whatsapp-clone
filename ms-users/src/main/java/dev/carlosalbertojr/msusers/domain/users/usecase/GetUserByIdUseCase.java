package dev.carlosalbertojr.msusers.domain.users.service;

import dev.carlosalbertojr.msusers.domain.shared.DomainService;
import dev.carlosalbertojr.msusers.domain.users.entity.UserDomain;
import dev.carlosalbertojr.msusers.domain.users.repository.UserRepository;
import dev.carlosalbertojr.msusers.domain.users.service.dto.GetUserByIdInput;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
public class GetUserByIdService implements DomainService<GetUserByIdInput, UserDomain> {

    private final UserRepository userRepository;


    @Override
    public Optional<UserDomain> execute(GetUserByIdInput input) {
        log.debug("Current thread name: {} - is virtual: {}", Thread.currentThread().getName(), Thread.currentThread().isVirtual());
        return userRepository.findById(input.userId());
    }
}
