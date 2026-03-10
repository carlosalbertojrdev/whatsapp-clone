package dev.carlosalbertojr.msusers.entrypoint.http.controller;

import dev.carlosalbertojr.msusers.domain.users.service.dto.GetUserByIdInput;
import dev.carlosalbertojr.msusers.entrypoint.http.exception.ResourceNotFoundException;
import dev.carlosalbertojr.msusers.entrypoint.http.payload.GetUserByIdResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import dev.carlosalbertojr.msusers.domain.shared.DomainService;
import dev.carlosalbertojr.msusers.domain.users.entity.UserDomain;
import dev.carlosalbertojr.msusers.domain.users.service.dto.CreateUserInput;
import dev.carlosalbertojr.msusers.entrypoint.http.payload.CreateUserRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final DomainService<CreateUserInput, UserDomain> createUserService;
    private final DomainService<GetUserByIdInput, UserDomain> getUserByIdService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody @Valid CreateUserRequest request) {
        createUserService.execute(new CreateUserInput(request.name(), request.email()));
    }


    @GetMapping("/{userId}")
    public GetUserByIdResponse getById(@PathVariable String userId) {
        return getUserByIdService.execute(new GetUserByIdInput(userId))
                .map((user) -> new GetUserByIdResponse(user.getId(), user.getName(), user.getEmail(), user.getCreatedAt()))
                .orElseThrow(() -> new ResourceNotFoundException("user not found"));
    }

}
