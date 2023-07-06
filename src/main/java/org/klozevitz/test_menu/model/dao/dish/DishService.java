package org.klozevitz.test_menu.model.dao.dish;

import lombok.RequiredArgsConstructor;
import org.klozevitz.test_menu.model.dao.IDaoDB;
import org.klozevitz.test_menu.model.entities.Menu.Dish;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DishService implements IDaoDB<Dish> {

    private final DishRepository dishRepository;

    @Override
    public List<Dish> findAll() {
        return null;
    }

    @Override
    public Mono<Dish> findById(Integer id) {
        return null;
    }

    @Override
    public Dish save(Dish dish) {
        return null;
    }

    @Override
    public Dish update(Dish dish) {
        return null;
    }

    @Override
    public Dish delete(Integer id) {
        return null;
    }
}
