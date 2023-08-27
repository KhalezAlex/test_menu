package org.klozevitz.test_menu.model.dao.menu;

import org.klozevitz.test_menu.model.entities.menu.Menu;
import org.springframework.data.repository.CrudRepository;

public interface MenuRepository extends CrudRepository<Menu, Integer> {
}
