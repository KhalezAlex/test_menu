package org.klozevitz.test_menu.model.dao.user;

import org.klozevitz.test_menu.model.dao.IDaoDB;
import org.klozevitz.test_menu.model.entities.users.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
public interface IDaoUser extends IDaoDB<User> {

    Optional<User> findUserByName(String name);
    User findUserByUsername(String name);
    void saveAdmin(User user);
    User addRole(Integer userId, String role);

}
