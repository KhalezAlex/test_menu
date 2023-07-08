package org.klozevitz.test_menu.model.dao;

import java.util.List;
import java.util.Optional;

public interface IDaoDB<E> {
    List<E> findAll();

    Optional<E> findById(Integer id);

    E save(E e);

    E update(E e);

    E delete(Integer id);
}
