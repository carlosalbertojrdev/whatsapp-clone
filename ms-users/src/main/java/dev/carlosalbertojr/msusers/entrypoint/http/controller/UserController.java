package dev.carlosalbertojr.msusers.entrypoint.http.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import dev.carlosalbertojr.msusers.domain.shared.DomainService;
import dev.carlosalbertojr.msusers.domain.users.entity.UserDomain;
import dev.carlosalbertojr.msusers.domain.users.service.dto.CreateUserInput;
import dev.carlosalbertojr.msusers.entrypoint.http.payload.CreateUserRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    private final DomainService<CreateUserInput, UserDomain> createUserService;

    public UserController(DomainService<CreateUserInput, UserDomain> createUserService) {
        this.createUserService = createUserService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody @Valid CreateUserRequest request) {
        createUserService.execute(new CreateUserInput(request.name(), request.email()));
    }

}
