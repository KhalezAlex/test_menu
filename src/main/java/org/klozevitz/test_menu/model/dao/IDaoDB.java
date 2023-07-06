package org.klozevitz.test_menu.model.dao;

import reactor.core.publisher.Mono;

import java.util.List;

public interface IDaoDB<E> {
    List<E> findAll();

    Mono<E> findById(Integer id);

    E save(E e);

    E update(E e);

    E delete(Integer id);
}
