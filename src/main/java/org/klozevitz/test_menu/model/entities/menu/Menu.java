package org.klozevitz.test_menu.model.entities.menu;

import jakarta.persistence.*;
import lombok.*;
import org.klozevitz.test_menu.model.entities.users.Company;

import java.util.HashSet;
import java.util.Set;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@Entity
@Table(name = "menu_t")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(mappedBy = "menu")
    private Company company;

    @OneToMany
    private Set<Dish> kitchen;

    @OneToMany
    private Set<Dish> bar;

    public Menu() {
        this.kitchen = new HashSet<>();
        this.bar = new HashSet<>();
    }
}
