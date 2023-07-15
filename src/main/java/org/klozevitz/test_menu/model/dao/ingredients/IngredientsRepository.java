package org.klozevitz.test_menu.model.dao.ingredients;

import org.klozevitz.test_menu.model.entities.menu.Ingredients;
import org.springframework.data.repository.CrudRepository;

public interface IngredientsRepository extends CrudRepository<Ingredients, Integer> {

}
