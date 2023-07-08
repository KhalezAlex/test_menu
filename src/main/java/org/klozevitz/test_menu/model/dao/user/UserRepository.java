package org.klozevitz.test_menu.model.dao.user;

import org.klozevitz.test_menu.model.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

}
