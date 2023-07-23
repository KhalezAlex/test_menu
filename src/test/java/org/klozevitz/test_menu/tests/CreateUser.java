package org.klozevitz.test_menu.tests;

import org.junit.jupiter.api.Test;
import org.klozevitz.test_menu.model.entities.role.Role;
import org.klozevitz.test_menu.model.entities.entity.User;

public class CreateUser {
    @Test
    void createUser(){
        User user = User.builder()
                .username("user1")
                .password("user")
                .role(Role.MANAGER)
                .build();
        System.out.println(user);
    }
}
