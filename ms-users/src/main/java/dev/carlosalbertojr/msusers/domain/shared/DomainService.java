package dev.carlosalbertojr.msusers.domain.shared;

import java.util.Optional;

public interface DomainService<I, O> {

    Optional<O> execute(I input);

} 
