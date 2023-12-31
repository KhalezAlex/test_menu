package org.klozevitz.test_menu.model.entities.menu;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.klozevitz.test_menu.model.entities.users.Company;

import java.util.Set;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "dish_t")
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Double price;

    //Картинки блюд
    @Lob
    private String photo;

    @ManyToMany
    @JoinTable(name = "dish_ingredients_t", joinColumns = @JoinColumn(name = "dish_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id"))
    private Set<Ingredient> ingredients;

    @ManyToOne
    private Menu menu;

    public Dish(String name, Double price, Menu menu) {
        this.name = name;
        this.price = price;
        this.menu = menu;
    }
}
