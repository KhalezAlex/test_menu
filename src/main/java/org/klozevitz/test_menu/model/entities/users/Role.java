package org.klozevitz.test_menu.model.entities.users;

import org.springframework.security.core.GrantedAuthority;

import java.util.stream.Stream;

public enum Role {
    ADMIN,
    COMPANY,
    MANAGER,
    WAITER,
    CHEF,
    COOK,
    HEAD_BARTENDER,
    BARTENDER;

    public static Stream<Role> stream() {
        return Stream.of(Role.values());
    }
}
