package org.klozevitz.test_menu.controllers;

import lombok.RequiredArgsConstructor;
import org.klozevitz.test_menu.model.dao.company.IDaoCompany;
import org.klozevitz.test_menu.model.dao.user.IDaoUser;
import org.klozevitz.test_menu.model.entities.users.Company;
import org.klozevitz.test_menu.model.entities.users.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/company")
@RequiredArgsConstructor
public class CompanyController {

    private final IDaoUser userDAO;
    private final IDaoCompany companyDAO;

    @PostMapping("/register")
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

        companyDAO.save(new Company(companyName, userDAO.save(new User(username, password))));

        return null;
    }
}
