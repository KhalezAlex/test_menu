package org.klozevitz.test_menu.controllers;

import lombok.RequiredArgsConstructor;
import org.klozevitz.test_menu.model.dao.company.IDaoCompany;
import org.klozevitz.test_menu.model.dao.profile.IDaoProfile;
import org.klozevitz.test_menu.model.dao.user.IDaoUser;
import org.klozevitz.test_menu.model.entities.users.Company;
import org.klozevitz.test_menu.model.entities.users.Profile;
import org.klozevitz.test_menu.model.entities.users.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/register")
@RequiredArgsConstructor
public class RegistrationController {

    private final IDaoUser userDAO;
    private final IDaoCompany companyDAO;
    private final IDaoProfile profileDAO;

    @GetMapping("/company")
    public String register(Model model){
        return "/login";
    }

    @PostMapping("/company")
    public String register(@RequestParam String username, @RequestParam String password,
                           RedirectAttributes ra, @RequestParam String companyName ){
        if (userDAO.findUserByUsername(username) != null) {
            ra.addFlashAttribute("error", "login");
            return "redirect:/register";
        }
        if(companyDAO.findCompanyByName(companyName) != null){
            ra.addFlashAttribute("error", "company_name");
            return "redirect:/register";
        }

        companyDAO.save(new Company(companyName, userDAO.save(new User(username, password))));

        return "/login";
    }

    @PostMapping("/employee")
    @PreAuthorize("hasRole('COMPANY')")
    public String registerPerson(@RequestParam String username, @RequestParam String password,
                                  RedirectAttributes ra, String role){
        //создает менеджера, шефов
        userDAO.saveEmployee(new User(username, password), role);
        return null;
    }

    @PostMapping("/manager")
    @PreAuthorize("hasRole('MANAGER')")
    public String registerManager(@RequestParam String username, @RequestParam String password,
                                   RedirectAttributes ra, String role){
        //создает официаетов, шефов
        userDAO.saveEmployee(new User(username, password), role);
        return null;
    }

    @PostMapping("/chef")
    @PreAuthorize("hasRole('CHEF')")
    public String registerChef(@RequestParam String username, @RequestParam String password,
                                RedirectAttributes ra, String role){
        //создает повара
        userDAO.saveEmployee(new User(username, password), role);
        return null;
    }

    @PostMapping("/bartender")
    @PreAuthorize("hasRole('BARTENDER')")
    public String registerBartender(@RequestParam String username, @RequestParam String password,
                                     RedirectAttributes ra, String role){
        //создает барменов
        userDAO.saveEmployee(new User(username, password), role);
        return null;
    }
}
