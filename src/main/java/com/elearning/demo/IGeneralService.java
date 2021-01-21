package com.elearning.demo;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface IGeneralService<T> {
    Iterable<T> findAll();

    T save(T t);

    Optional<T> findById(Long id);

    void remove(Long id);

    Iterable<T> findAllDeleted();
}
