package org.klozevitz.test_menu.model.dao.user;

import org.klozevitz.test_menu.model.dao.IDaoDB;
import org.klozevitz.test_menu.model.entities.User;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface IDaoUser extends IDaoDB<User> {

    User findUserByName(String login);
    void saveAdmin(User user);
    User addRole(Integer userId, String role);

}
