package org.klozevitz.test_menu.model.entities.manager;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.klozevitz.test_menu.model.entities.company.Company;
import org.klozevitz.test_menu.model.entities.kitchen.chef_cooker.ChefCooker;
import org.klozevitz.test_menu.model.entities.pub.chef_bartender.ChefBartender;
import org.klozevitz.test_menu.model.entities.waiter.Waiter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class Manager {

    private Integer id;

    private String name;

    private String lastName;

    private String surName;

    private Boolean certificate;

    private Company company;

    private Set<ChefCooker> chefCookerSet;

    private Set<ChefBartender> chefBartenderSet;

    private Set<Waiter> waiterSet;
}
