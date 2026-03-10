package dev.carlosalbertojr.msusers.domain.shared;

import java.util.Optional;

public interface UseCase<I, O> {

    Optional<O> execute(I input);

} 
