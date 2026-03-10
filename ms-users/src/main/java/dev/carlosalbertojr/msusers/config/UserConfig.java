package dev.carlosalbertojr.msusers.config;

import dev.carlosalbertojr.msusers.domain.users.service.GetUserByIdService;
import dev.carlosalbertojr.msusers.domain.users.service.dto.GetUserByIdInput;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dev.carlosalbertojr.msusers.domain.shared.DomainService;
import dev.carlosalbertojr.msusers.domain.users.entity.UserDomain;
import dev.carlosalbertojr.msusers.domain.users.repository.UserRepository;
import dev.carlosalbertojr.msusers.domain.users.service.CreateUserService;
import dev.carlosalbertojr.msusers.domain.users.service.dto.CreateUserInput;
import dev.carlosalbertojr.msusers.infrastructure.persistence.repository.UserJpaRepository;
import dev.carlosalbertojr.msusers.infrastructure.persistence.repository.impl.DefaultUserRepository;

@Configuration
public class UserConfig {

    @Bean
    DomainService<CreateUserInput, UserDomain> createUserService(
        UserRepository userRepository
    ) {
        return new CreateUserService(userRepository);
    }

    @Bean
    DomainService<GetUserByIdInput, UserDomain> getUserByIdService(
            UserRepository userRepository
    ) {
        return new GetUserByIdService(userRepository);
    }

    @Bean
    UserRepository userRepository(UserJpaRepository userJpaRepository) {
        return new DefaultUserRepository(userJpaRepository);
    }

}
