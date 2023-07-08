package org.klozevitz.test_menu.model.dao.ingredients;

import org.klozevitz.test_menu.model.entities.Menu.Ingredients;
import org.springframework.data.repository.CrudRepository;

public interface IngredientsRepository extends CrudRepository<Ingredients, Integer> {

}
