package org.klozevitz.test_menu.model.entities.users;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.klozevitz.test_menu.model.entities.menu.Menu;
import org.klozevitz.test_menu.model.entities.users.User;
import org.klozevitz.test_menu.model.entities.menu.Dish;

import java.util.Set;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "company_t")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "premium")
    private Boolean premium;

    public Company(String name, User user) {
        this.name = name;
        this.user = user;
        this.premium = false;
    }

    @OneToOne(cascade = CascadeType.ALL)
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "menu_id", referencedColumnName = "id")
    private Menu menu;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private Set<Profile> employees;
}
