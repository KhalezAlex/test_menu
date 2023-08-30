package org.klozevitz.test_menu.model.dao.dish;

import lombok.RequiredArgsConstructor;
import org.klozevitz.test_menu.model.dao.IDaoDB;
import org.klozevitz.test_menu.model.entities.menu.Dish;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DishService implements IDaoDish {

    private final DishRepository dishRepository;

    @Override
    public List<Dish> findAll() {
        return (List<Dish>) dishRepository.findAll();
    }

    @Override
    public Optional<Dish> findById(Integer id) {
        return dishRepository.findById(id);
    }

    @Override
    public Dish save(Dish dish) {
        return dishRepository.save(dish);
    }

    @Override
    public Dish update(Dish dish) {
        if(dishRepository.findById(dish.getId()).isPresent()){
            return dishRepository.save(dish);
        }
        return null;
    }

    @Override
    public Dish delete(Integer id) {
        Dish dish = findById(id).get();
        dishRepository.delete(dish);
        return dish;
    }
}