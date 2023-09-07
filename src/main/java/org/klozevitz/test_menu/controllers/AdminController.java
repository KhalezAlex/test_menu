package org.klozevitz.test_menu.controllers;

import lombok.RequiredArgsConstructor;
import org.klozevitz.test_menu.model.dao.user.IDaoUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final IDaoUser userDAO;

    @GetMapping("/all")
    public String all(Model model) {
        model.addAttribute("user", userDAO.findAll());
        model.addAttribute("navSelected", "customer");
        return "admin/admin-user";
    }
}
