package dev.carlosalbertojr.msusers.config;

import dev.carlosalbertojr.msusers.domain.users.usecase.GetUserByIdUseCase;
import dev.carlosalbertojr.msusers.domain.users.usecase.dto.GetUserByIdInput;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dev.carlosalbertojr.msusers.domain.shared.UseCase;
import dev.carlosalbertojr.msusers.domain.users.entity.UserDomain;
import dev.carlosalbertojr.msusers.domain.users.repository.UserRepository;
import dev.carlosalbertojr.msusers.domain.users.usecase.CreateUserUseCase;
import dev.carlosalbertojr.msusers.domain.users.usecase.dto.CreateUserInput;
import dev.carlosalbertojr.msusers.infrastructure.persistence.repository.UserJpaRepository;
import dev.carlosalbertojr.msusers.infrastructure.persistence.repository.impl.DefaultUserRepository;

@Configuration
public class UserConfig {

    @Bean
    UseCase<CreateUserInput, UserDomain> createUserUseCase(
        UserRepository userRepository
    ) {
        return new CreateUserUseCase(userRepository);
    }

    @Bean
    UseCase<GetUserByIdInput, UserDomain> getUserByIdUseCase(
            UserRepository userRepository
    ) {
        return new GetUserByIdUseCase(userRepository);
    }

    @Bean
    UserRepository userRepository(UserJpaRepository userJpaRepository) {
        return new DefaultUserRepository(userJpaRepository);
    }

}
