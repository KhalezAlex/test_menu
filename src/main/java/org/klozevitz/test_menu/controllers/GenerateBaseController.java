package org.klozevitz.test_menu.controllers;

import lombok.RequiredArgsConstructor;
import org.klozevitz.test_menu.model.dao.company.IDaoCompany;
import org.klozevitz.test_menu.model.dao.profile.IDaoProfile;
import org.klozevitz.test_menu.model.dao.user.IDaoUser;
import org.klozevitz.test_menu.model.entities.users.Company;
import org.klozevitz.test_menu.model.entities.users.Profile;
import org.klozevitz.test_menu.model.entities.users.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//JWT работает с REST
@Controller
@ResponseBody
@RequestMapping(path = "/service")
@RequiredArgsConstructor
public class GenerateBaseController {
    private final IDaoUser userDAO;
    private final IDaoCompany companyDAO;
    private final IDaoProfile profileDAO;

    @GetMapping("/generateBase")
    public String generate() {
        userDAO.saveAdmin(new User("admin", "admin"));//1

//        companyDAO.save(new Company("Danone", userDAO.save(new User("danone", "danone"))));//2
//        companyDAO.save(new Company("Rocs", userDAO.save(new User("rocs", "rocs"))));//3

        userDAO.saveEmployee(new User("Manager_Danone", "123",
                new Profile(companyDAO.findCompanyByUserId(2))), "Manager");//4//1
        userDAO.saveEmployee(new User("Manager_Rocs", "123",
                new Profile(companyDAO.findCompanyByUserId(3))), "Manager");//5//2

        userDAO.saveEmployee(new User("Waiter_Danone", "123",
                new Profile(companyDAO.findById(1).get(), profileDAO.findById(1).get())), "WAITER");//6 - 3
        userDAO.saveEmployee(new User("Waiter_Rocs", "123",
                new Profile(companyDAO.findById(2).get(), profileDAO.findById(2).get())), "WAITER");//7 - 4

        userDAO.saveEmployee(new User("Chef_Danone", "123",
                new Profile(companyDAO.findById(1).get())), "Chef");//8 - 5
        userDAO.saveEmployee(new User("Chef_Rocs", "123",
                new Profile(companyDAO.findById(2).get())), "Chef");//9 - 6

        userDAO.saveEmployee(new User("HBARTENDER_Danone", "123",
                new Profile(companyDAO.findById(1).get())), "HEAD_BARTENDER");//10 - 7
        userDAO.saveEmployee(new User("HBARTENDER_Rocs", "123",
                new Profile(companyDAO.findById(2).get())), "HEAD_BARTENDER");//11 - 8

        userDAO.saveEmployee(new User("Cook_Danone", "123",
                new Profile(companyDAO.findById(1).get(), profileDAO.findById(5).get())), "COOK");//12 - 9
        userDAO.saveEmployee(new User("Cook_Rocs", "123",
                new Profile(companyDAO.findById(2).get(), profileDAO.findById(6).get())), "COOK");//13 - 10

        userDAO.saveEmployee(new User("Bartender_Danone", "123",
                new Profile(companyDAO.findById(1).get(), profileDAO.findById(10).get())), "BARTENDER");//14 - 11
        userDAO.saveEmployee(new User("Bartender_Rocs", "123",
                new Profile(companyDAO.findById(2).get(), profileDAO.findById(11).get())), "BARTENDER");//15 - 12
       return "/";
    }

}
