package org.klozevitz.test_menu.model.entities.kitchen.chef_cooker;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.klozevitz.test_menu.model.entities.company.Company;
import org.klozevitz.test_menu.model.entities.kitchen.cook.Cook;
import org.klozevitz.test_menu.model.entities.manager.Manager;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class ChefCooker {

    private Integer id;

    private String name;

    private String lastName;

    private String surName;

    private Boolean certificate;

    private Company company;

    private Set<Manager> managerSet;

    private Set<Cook> cookSet;
}
