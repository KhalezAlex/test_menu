package org.klozevitz.test_menu.controllers;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.klozevitz.test_menu.model.dao.user.IDaoUser;
import org.klozevitz.test_menu.model.entities.users.Role;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping(path = "/")
@RequiredArgsConstructor
public class ViewController {

    private final IDaoUser userDAO;
    @GetMapping("/")
    public String home() {
        return "pages/home";
    }

    @GetMapping("/login")
    public String login() {
        return "pages/login";
    }

    @GetMapping("/register/company")
    public String registerCompany() {
        return "pages/register/company";
    }

    @GetMapping("/register/chiefs")
    public String chiefs(Model model, Authentication auth) {
        model.addAttribute("companyId", userDAO.findUserByUsername(auth.getName()).getId());
        model.addAttribute("roles", roles());
        return "pages/register/chiefs";
    }

    private List<Role> roles() {
        List<Role> roles = new LinkedList<>();
        roles.add(Role.HEAD_BARTENDER);
        roles.add(Role.CHEF);
        roles.add(Role.MANAGER);
        return roles;
    }

    @GetMapping("/register/managerSubs")
    public String manager(Model model, Authentication auth) {
        model.addAttribute("manager", userDAO.findUserByUsername(auth.getName()));
        return "pages/register/managerSubs";
    }

    @GetMapping("/register/chefSubs")
    public String cook(Model model, Authentication auth) {
        model.addAttribute("chef", userDAO.findUserByUsername(auth.getName()));
        return "pages/register/chefSubs";
    }

    @GetMapping("/register/bartenderSubs")
    public String bartender(Model model, Authentication auth) {
        model.addAttribute("bartender", userDAO.findUserByUsername(auth.getName()));
        return "pages/register/bartenderSubs";
    }

    @GetMapping("/menu/add")
    public String menu(Model model, Authentication auth){
        model.addAttribute("user", userDAO.findUserByUsername(auth.getName()));
        return "pages/menu/menu";
    }

    @GetMapping("/logout")
    public  String logout(HttpServletRequest request) {
        if (SecurityContextHolder.getContext().getAuthentication() != null) {
            request.getSession().invalidate();
        }
        return "pages/home";
    }
}
