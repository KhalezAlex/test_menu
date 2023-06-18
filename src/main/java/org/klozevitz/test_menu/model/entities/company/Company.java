package org.klozevitz.test_menu.model.entities.company;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.klozevitz.test_menu.model.entities.kitchen.chef_cooker.ChefCooker;
import org.klozevitz.test_menu.model.entities.kitchen.cook.Cook;
import org.klozevitz.test_menu.model.entities.manager.Manager;
import org.klozevitz.test_menu.model.entities.pub.bartender.Bartender;
import org.klozevitz.test_menu.model.entities.pub.chef_bartender.ChefBartender;
import org.klozevitz.test_menu.model.entities.waiter.Waiter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class Company {

    private Integer id;

    private String name;

    private Double staff;

    private String field;

    private Integer price;

    private Set<Manager> managerSet;

    private Set<ChefCooker> chefCookers;

    private Set<ChefBartender> chefBartenders;

    private Set<Cook> cooks;

    private Set<Bartender> bartenders;

    private Set<Waiter> waiters;

}
