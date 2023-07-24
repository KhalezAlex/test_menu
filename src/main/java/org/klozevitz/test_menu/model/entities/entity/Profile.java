package org.klozevitz.test_menu.model.entities.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.klozevitz.test_menu.model.entities.menu.Dish;

import java.util.Set;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "profile_t")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(mappedBy = "profile")
    private User user;

    @ManyToMany
    @JoinTable(name = "user_dishes_t", joinColumns = @JoinColumn(name = "profile_id"),
            inverseJoinColumns = @JoinColumn(name = "dish_id"))
    private Set<Dish> dishes;

}
