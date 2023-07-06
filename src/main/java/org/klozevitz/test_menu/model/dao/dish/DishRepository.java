package org.klozevitz.test_menu.model.dao.dish;

import org.klozevitz.test_menu.model.entities.Menu.Dish;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface DishRepository extends R2dbcRepository<Dish, Integer> {
}
