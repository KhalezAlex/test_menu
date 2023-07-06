package org.klozevitz.test_menu.mapper;

import org.klozevitz.test_menu.model.dto.UserDTO;
import org.klozevitz.test_menu.model.entities.User;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO map(User user);

    @InheritInverseConfiguration
    User user(UserDTO dto);
}
