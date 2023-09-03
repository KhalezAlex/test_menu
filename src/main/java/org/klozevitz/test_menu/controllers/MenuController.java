package org.klozevitz.test_menu.controllers;

import lombok.RequiredArgsConstructor;
import org.klozevitz.test_menu.model.dao.company.IDaoCompany;
import org.klozevitz.test_menu.model.dao.dish.IDaoDish;
import org.klozevitz.test_menu.model.dao.menu.IDaoMenu;
import org.klozevitz.test_menu.model.entities.menu.Dish;
import org.klozevitz.test_menu.model.entities.menu.Menu;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/menu")
@RequiredArgsConstructor
public class MenuController {

    public final IDaoMenu menuDAO;
    public final IDaoCompany companyDAO;
    public final IDaoDish dishDAO;

    @PostMapping("/add")
    public String menu(@ModelAttribute Menu menu , @RequestParam String dish, @RequestParam Integer id, @RequestParam String dishName,
                       @RequestParam Double price){

        Dish kitchen = new Dish(dishName, price, companyDAO.findCompanyByUserId(id), menuDAO.findById(1).get());
        System.out.println(kitchen.getCompany().getName());

        return "redirect:/menu/register";

    }

}
