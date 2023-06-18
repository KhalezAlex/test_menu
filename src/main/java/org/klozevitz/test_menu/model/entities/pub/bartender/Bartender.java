package org.klozevitz.test_menu.model.entities.pub.bartender;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.klozevitz.test_menu.model.entities.company.Company;
import org.klozevitz.test_menu.model.entities.pub.chef_bartender.ChefBartender;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class Bartender {

    private Integer id;

    private String name;

    private String lastName;

    private String surName;

    private Boolean certificate;

    private Company company;

    private Set<ChefBartender> chefBartenderSet;
}
