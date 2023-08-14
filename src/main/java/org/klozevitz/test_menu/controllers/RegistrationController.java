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
                                  RedirectAttributes ra, String role, Integer id){
        //создает менеджера, шефов
        if (userDAO.findUserByUsername(username) != null) {
            ra.addFlashAttribute("error", "login");
            return "redirect:/register";
        }
        /*При создании работника передаётся логин, пароль, роль, ID получаем через фронт,
         он должен быть равен ID пользователя, тк связь с компанией идёт через него.
         И далее в профиль передаётся компания по найденой связи*/
        userDAO.saveEmployee(new User(username, password, new Profile(companyDAO.findCompanyByUserId(id))), role);
        return null;
    }

    @PostMapping("/manager")
    @PreAuthorize("hasRole('MANAGER')")
    public String registerManager(@RequestParam String username, @RequestParam String password,
                                   RedirectAttributes ra, String role, Integer id, Integer chefId){
        //создает официаетов, шефов
        if (userDAO.findUserByUsername(username) != null) {
            ra.addFlashAttribute("error", "login");
            return "redirect:/register";
        }
        //Добавить связь с менеджером в профиле официанта
        /*Тут так же похожая механика, делаем проверку на роли, тк необходимо связь с начальником.
        Но ID тут берётся из профиля потому что связь уже есть с компанией
        chefId = Id профайла Менеджера*/
        if  (role.equalsIgnoreCase("Waiter")) {
            userDAO.saveEmployee(new User(username, password, new Profile(companyDAO.findById(id).get(),
                    profileDAO.findById(chefId).get())), role);
        }
        else {
            userDAO.saveEmployee(new User(username, password, new Profile(companyDAO.findById(id).get())), role);
        }
        return null;
    }

    @PostMapping("/chef")
    @PreAuthorize("hasRole('CHEF')")
    public String registerChef(@RequestParam String username, @RequestParam String password,
                                RedirectAttributes ra, String role, Integer id, Integer chefId){
        //создает повара
        if (userDAO.findUserByUsername(username) != null) {
            ra.addFlashAttribute("error", "login");
            return "redirect:/register";
        }
        //Добавить связь с шефом в профиле
        userDAO.saveEmployee(new User(username, password, new Profile(companyDAO.findById(id).get(),
                profileDAO.findById(chefId).get())), role);
        return null;
    }

    @PostMapping("/bartender")
    @PreAuthorize("hasRole('BARTENDER')")
    public String registerBartender(@RequestParam String username, @RequestParam String password,
                                     RedirectAttributes ra, String role, Integer id, Integer chefId){
        //создает барменов
        if (userDAO.findUserByUsername(username) != null) {
            ra.addFlashAttribute("error", "login");
            return "redirect:/register";
        }
        //Добавить связь с шефом в профиле
        userDAO.saveEmployee(new User(username, password, new Profile(companyDAO.findById(id).get(),
                profileDAO.findById(chefId).get())), role);
        return null;
    }
}
