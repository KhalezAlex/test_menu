package org.klozevitz.test_menu.tests;

import org.junit.jupiter.api.Test;
import org.klozevitz.test_menu.model.entities.users.Role;
import org.klozevitz.test_menu.model.entities.users.User;

public class CreateUser {
    @Test
    User create_createUserWithManagerRole_User(){
        return User.builder()
                .username("user1")
                .password("user")
                .role(Role.ROLE_MANAGER)
                .build();
    }
}
