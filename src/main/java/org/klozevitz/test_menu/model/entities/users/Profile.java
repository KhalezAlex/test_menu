package org.klozevitz.test_menu.model.entities.users;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
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

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "age")
    private Integer age;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    public Profile(Company company) {
        this.company = company;
    }

    public Profile(Company company, Profile chief) {
        this.company = company;
        this.chief = chief;
        this.subs = new HashSet<>();
    }

    //список подчиненных
    @OneToMany
    private Set<Profile> subs;
    //непосредственный начальник
    @ManyToOne
    private Profile chief;
}
