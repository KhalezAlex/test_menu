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
@Table(name = "ingredients_t")
public class Ingredients {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "gross")
    private Double gross;

    @Column(name = "net")
    private String net;

    @ManyToMany(mappedBy = "ingredientsList")
    private Set<Dish> dishes;
}
