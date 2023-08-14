package org.klozevitz.test_menu.model.entities.users;

import lombok.Getter;

import java.util.stream.Stream;

@Getter
public enum Role {
    ROLE_ADMIN,
    ROLE_COMPANY,
    ROLE_MANAGER,
    ROLE_WAITER,
    ROLE_CHEF,
    ROLE_COOK,
    ROLE_HEAD_BARTENDER,
    ROLE_BARTENDER;

    public static Stream<Role> stream() {
        return Stream.of(Role.values());
    }
}
