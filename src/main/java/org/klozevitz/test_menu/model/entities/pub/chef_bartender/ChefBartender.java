package org.klozevitz.test_menu.model.entities.pub.chef_bartender;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.klozevitz.test_menu.model.entities.company.Company;
import org.klozevitz.test_menu.model.entities.manager.Manager;
import org.klozevitz.test_menu.model.entities.pub.bartender.Bartender;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class ChefBartender {

    private Integer id;

    private String name;

    private String lastName;

    private String surName;

    private Boolean certificate;

    private Company company;

    private Set<Manager> managerSet;

    private Set<Bartender> bartenderSet;
}
