package org.klozevitz.test_menu.model.dao.ingredients;

import org.klozevitz.test_menu.model.entities.Menu.Ingredients;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface IngredientsRepository extends R2dbcRepository<Ingredients, Integer> {
}
