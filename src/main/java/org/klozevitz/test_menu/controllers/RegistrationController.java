package org.klozevitz.test_menu.controllers;

import lombok.RequiredArgsConstructor;
import org.klozevitz.test_menu.model.dao.company.IDaoCompany;
import org.klozevitz.test_menu.model.dao.menu.IDaoMenu;
import org.klozevitz.test_menu.model.dao.profile.IDaoProfile;
import org.klozevitz.test_menu.model.dao.user.IDaoUser;
import org.klozevitz.test_menu.model.entities.menu.Menu;
import org.klozevitz.test_menu.model.entities.users.Company;
import org.klozevitz.test_menu.model.entities.users.Profile;
import org.klozevitz.test_menu.model.entities.users.User;
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
    private final IDaoMenu menuDAO;

    @PostMapping("/company")
    public String register(@RequestParam String username, @RequestParam String password,
                           RedirectAttributes ra, @RequestParam String companyName) {
        if (userDAO.findUserByUsername(username) != null) {
            ra.addFlashAttribute("error", "login");
            return "redirect:/register";
        }
        if (companyDAO.findCompanyByName(companyName) != null) {
            ra.addFlashAttribute("error", "company_name");
            return "redirect:/register";
        }
        companyDAO.save(new Company(companyName, userDAO.save(new User(username, password)), menuDAO.save(new Menu())));
        return "pages/login";
    }

    /**
     * При создании работника передаётся логин, пароль, роль, ID получаем через фронт,
     * он должен быть равен ID пользователя, тк связь с компанией идёт через него.
     * И далее в профиль передаётся компания по найденой связи
     */
    @PostMapping("/chiefs")
    public String chiefs(@RequestParam String username, @RequestParam String password,
                           @RequestParam String role, @RequestParam Integer id, RedirectAttributes ra) {
        if (userDAO.findUserByUsername(username) != null) {
            ra.addFlashAttribute("error", "login");
            return "redirect:/register/chiefs";
        }
        userDAO.saveEmployee(new User(username, password, new Profile(companyDAO.findCompanyByUserId(id))), role);
        return "pages/home";
    }

    /**
     * Тут также похожая механика: делаем проверку на роли, тк необходима связь с начальником.
     * Но ID тут берётся из профиля потому что связь уже есть с компанией
     * chefId = Id профайла Менеджера
     */
    @PostMapping("/managerSubs")
    public String managerSubs(@RequestParam String username, @RequestParam String password, RedirectAttributes ra,
                              @RequestParam String role, @RequestParam Integer id, @RequestParam Integer chefId) {
        if (userDAO.findUserByUsername(username) != null || companyDAO.findById(id).isEmpty()
                || profileDAO.findById(chefId).isEmpty()) {
            ra.addFlashAttribute("error", "login");
            return "redirect:/register/managerSubs";
        }
        if (role.equalsIgnoreCase("Waiter")) {
            userDAO.saveEmployee(new User(username, password,
                    new Profile(companyDAO.findById(id).get(), profileDAO.findById(chefId).get())), role);
        } else {
            userDAO.saveEmployee(new User(username, password, new Profile(companyDAO.findById(id).get())), role);
        }
        return "pages/home";
    }

    @PostMapping("/chefSubs")
    public String chefSubs(@RequestParam String username, @RequestParam String password, RedirectAttributes ra,
                           @RequestParam Integer id, @RequestParam Integer chefId) {
        //создает повара
        if (userDAO.findUserByUsername(username) != null || companyDAO.findById(id).isEmpty()
                || profileDAO.findById(chefId).isEmpty()) {
            ra.addFlashAttribute("error", "login");
            return "redirect:/register";
        }
        userDAO.saveEmployee(new User(username, password, new Profile(companyDAO.findById(id).get(),
                profileDAO.findById(chefId).get())), "COOK");
        return "pages/home";
    }

    @PostMapping("/bartenderSubs")
    public String bartenderSubs(@RequestParam String username, @RequestParam String password, RedirectAttributes ra,
                                @RequestParam Integer id, @RequestParam Integer chefId) {
        //создает барменов
        if (userDAO.findUserByUsername(username) != null || companyDAO.findById(id).isEmpty()
                || profileDAO.findById(chefId).isEmpty()) {
            ra.addFlashAttribute("error", "login");
            return "redirect:/register";
        }
        //Добавить связь с шефом барменов в профиле
        userDAO.saveEmployee(new User(username, password, new Profile(companyDAO.findById(id).get(),
                profileDAO.findById(chefId).get())), "BARTENDER");
        return "pages/home";
    }
}
