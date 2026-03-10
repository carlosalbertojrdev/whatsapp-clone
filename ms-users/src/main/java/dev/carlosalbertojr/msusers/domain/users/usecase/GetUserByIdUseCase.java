package dev.carlosalbertojr.msusers.domain.users.usecase;

import dev.carlosalbertojr.msusers.domain.shared.UseCase;
import dev.carlosalbertojr.msusers.domain.users.entity.UserDomain;
import dev.carlosalbertojr.msusers.domain.users.repository.UserRepository;
import dev.carlosalbertojr.msusers.domain.users.usecase.dto.GetUserByIdInput;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
public class GetUserByIdUseCase implements UseCase<GetUserByIdInput, UserDomain> {

    private final UserRepository userRepository;


    @Override
    public Optional<UserDomain> execute(GetUserByIdInput input) {
        return userRepository.findById(input.userId());
    }
}
