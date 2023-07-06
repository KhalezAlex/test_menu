package org.klozevitz.test_menu.model.dao.user;

import org.klozevitz.test_menu.model.entities.User;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface UserRepository extends R2dbcRepository<User, Integer> {
}
