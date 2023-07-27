package org.klozevitz.test_menu.model.entities.menu;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ingredient_t")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "brutto")
    private Double brutto;

    @Column(name = "netto")
    private Double netto;

    @ManyToMany(mappedBy = "ingredients")
    private Set<Dish> dishes;
}
