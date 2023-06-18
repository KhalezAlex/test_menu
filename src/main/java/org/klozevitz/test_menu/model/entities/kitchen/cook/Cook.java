package org.klozevitz.test_menu.model.entities.kitchen.cook;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.klozevitz.test_menu.model.entities.company.Company;
import org.klozevitz.test_menu.model.entities.kitchen.chef_cooker.ChefCooker;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class Cook {

    private Integer id;

    private String name;

    private String lastName;

    private String surName;

    private Boolean certificate;

    private Company company;

    private Set<ChefCooker> chefCookerSet;
}
