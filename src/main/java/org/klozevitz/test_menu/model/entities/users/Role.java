package org.klozevitz.test_menu.model.entities.users;

import lombok.Getter;

@Getter
public enum Role {
    ADMIN,
    COMPANY,
    MANAGER,
    WAITER,
    CHEF,
    COOK,
    HEAD_BARTENDER,
    BARTENDER;
}
