package org.klozevitz.test_menu.controllers;

import lombok.RequiredArgsConstructor;
import org.klozevitz.test_menu.model.dao.company.IDaoCompany;
import org.klozevitz.test_menu.model.dao.profile.IDaoProfile;
import org.klozevitz.test_menu.model.dao.user.IDaoUser;
import org.klozevitz.test_menu.model.entities.users.Company;
import org.klozevitz.test_menu.model.entities.users.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
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

    @PostMapping("/company")
    public String register(@RequestParam String username, @RequestParam String password,
                           @RequestParam String passRepeat, RedirectAttributes ra, @RequestParam String companyName ){
        if (!passRepeat.equals(password)){
            ra.addFlashAttribute("error", "password");
            return "redirect:/register";
        }
        if (userDAO.findUserByUsername(username) != null) {
            ra.addFlashAttribute("error", "login");
            return "redirect:/register";
        }
        if(companyDAO.findCompanyByName(companyName) != null){
            ra.addFlashAttribute("error", "company_name");
            return "redirect:/register";
        }

        companyDAO.save(new Company(companyName, userDAO.save(new User(username, password
//                ,profileDAO.save(new Profile())) //
        ))));

        return null;
    }

    @PostMapping("/company")
    @PreAuthorize("hasRole('COMPANY')")
    public String registerPerson(@RequestParam String username, @RequestParam String password,
                                 @RequestParam String passRepeat, RedirectAttributes ra, String role){
        //создает менеджера, шефов
        userDAO.saveEmployee(new User(username, password), role);
        return null;
    }

    @PostMapping("/manager")
    @PreAuthorize("hasRole('MANAGER')")
    public String registerManager(@RequestParam String username, @RequestParam String password,
                                  @RequestParam String passRepeat, RedirectAttributes ra, String role){
        //создает официаетов, шефов
        userDAO.saveEmployee(new User(username, password), role);
        return null;
    }

    @PostMapping("/chef")
    @PreAuthorize("hasRole('CHEF')")
    public String registerChef(@RequestParam String username, @RequestParam String password,
                               @RequestParam String passRepeat, RedirectAttributes ra, String role){
        //создает повара
        userDAO.saveEmployee(new User(username, password), role);
        return null;
    }

    @PostMapping("/bartender")
    @PreAuthorize("hasRole('BARTENDER')")
    public String registerBartender(@RequestParam String username, @RequestParam String password,
                                    @RequestParam String passRepeat, RedirectAttributes ra, String role){
        //создает барменов
        userDAO.saveEmployee(new User(username, password), role);
        return null;
    }
}
