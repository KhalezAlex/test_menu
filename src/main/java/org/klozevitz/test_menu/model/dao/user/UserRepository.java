package org.klozevitz.test_menu.model.dao.user;

import org.klozevitz.test_menu.model.entities.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {
   Optional<User> findByUsername(String name);
   User findUserByUsername(String name);

}
