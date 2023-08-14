package org.klozevitz.test_menu.controllers;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.klozevitz.test_menu.model.dao.company.IDaoCompany;
import org.klozevitz.test_menu.model.dao.user.IDaoUser;
import org.klozevitz.test_menu.model.entities.users.Role;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.stream.Stream;

@Controller
@RequestMapping(path = "/")
@RequiredArgsConstructor
public class ViewController {

    private final IDaoUser userDAO;
    @GetMapping("/")
    public String home() {
        System.out.println("mapping \"home\"");
        System.out.println(SecurityContextHolder.getContext().getAuthentication());
        return "pages/home";
    }

    @GetMapping("/login")
    public String login() {
        return "pages/login";
    }

    @GetMapping("/register/company")
    public String register() {
        return "pages/register/company";
    }

    @GetMapping("/register/chiefs")
    public String chiefs(Model model) {
        System.out.println("/register/chiefs");
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getName());
        System.out.println(userDAO.findUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName()));
        return "pages/register/chiefs";
    }

    @GetMapping("/logout")
    public  String logout(HttpServletRequest request) {
        if (SecurityContextHolder.getContext().getAuthentication() != null) {
            request.getSession().invalidate();
        }
        return "pages/home";
    }
}
