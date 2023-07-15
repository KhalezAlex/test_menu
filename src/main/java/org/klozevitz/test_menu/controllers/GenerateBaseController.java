package org.klozevitz.test_menu.controllers;

import lombok.RequiredArgsConstructor;
import org.klozevitz.test_menu.model.dao.user.IDaoUser;
import org.klozevitz.test_menu.model.entities.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/service")
@RequiredArgsConstructor
public class GenerateBaseController {
    private final IDaoUser iDaoUser;

    @GetMapping("/generateBase")
    public String generate() {
        iDaoUser.saveAdmin(new User("user", "user"));
       return "/";
    }
}
