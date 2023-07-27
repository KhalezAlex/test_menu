package org.klozevitz.test_menu.model.entities.users;

import lombok.Getter;

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
}
