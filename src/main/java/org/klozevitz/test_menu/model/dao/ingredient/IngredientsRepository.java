package org.klozevitz.test_menu.model.dao.ingredient;

import org.klozevitz.test_menu.model.entities.menu.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientsRepository extends CrudRepository<Ingredient, Integer> {

}
