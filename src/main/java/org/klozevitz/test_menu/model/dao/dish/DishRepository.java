package org.klozevitz.test_menu.model.dao.dish;

import org.klozevitz.test_menu.model.entities.menu.Dish;
import org.springframework.data.repository.CrudRepository;

public interface DishRepository extends CrudRepository<Dish, Integer> {
}
