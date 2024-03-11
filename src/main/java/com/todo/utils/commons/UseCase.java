package com.todo.utils.commons;

import jakarta.validation.Valid;

import java.util.Optional;

@FunctionalInterface
public interface UseCase<I extends UseCaseRequest, O extends UseCaseResponse> {
    Optional<O> execute(@Valid I request);
}
