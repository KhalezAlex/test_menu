package org.klozevitz.test_menu.model.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.klozevitz.test_menu.model.entities.users.Profile;
import org.klozevitz.test_menu.model.entities.menu.Ingredient;

import java.util.Set;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class DishDTO {
    private Integer id;
    private String name;
    private Double price;
    private Set<Ingredient> ingredientList;
    private Set<Profile> profiles;
}
