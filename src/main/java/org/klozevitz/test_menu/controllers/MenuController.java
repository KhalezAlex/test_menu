package org.klozevitz.test_menu.controllers;

import lombok.RequiredArgsConstructor;
import org.klozevitz.test_menu.model.dao.company.IDaoCompany;
import org.klozevitz.test_menu.model.dao.dish.IDaoDish;
import org.klozevitz.test_menu.model.dao.menu.IDaoMenu;
import org.klozevitz.test_menu.model.entities.menu.Dish;
import org.klozevitz.test_menu.model.entities.menu.Menu;
import org.klozevitz.test_menu.model.entities.users.Company;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/menu")
@RequiredArgsConstructor
public class MenuController {

    public final IDaoMenu menuDAO;
    public final IDaoCompany companyDAO;
    public final IDaoDish dishDAO;

    @PostMapping("/add")
    public String menu(@RequestParam String bar, @RequestParam Integer id, @RequestParam String dishName,
                       @RequestParam Double price){
        Menu menu = companyDAO.findCompanyByUserId(id).getMenu();
        Dish dish = dishDAO.save(new Dish(dishName, price, menu));
        if (bar.equals("bar")){
            System.out.println("36");
            System.out.println(menu.getId());
            System.out.println(dish.getName());
            System.out.println(menu.getBar());
            menu.getBar().add(dish);
            System.out.println("38");
        } else {
            System.out.println("40");
            menu.getKitchen().add(dish);
        }
        System.out.println("43");
//        menuDAO.update(menu);
        return "redirect:/menu/add";
    }
}
