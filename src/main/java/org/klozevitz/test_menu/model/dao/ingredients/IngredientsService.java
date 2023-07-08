package org.klozevitz.test_menu.model.dao.ingredients;

import lombok.RequiredArgsConstructor;
import org.klozevitz.test_menu.model.dao.IDaoDB;
import org.klozevitz.test_menu.model.entities.Menu.Ingredients;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class IngredientsService implements IDaoDB<Ingredients> {

    private final IngredientsRepository ir;


    @Override
    public List<Ingredients> findAll() {
        return (List<Ingredients>) ir.findAll();
    }

    @Override
    public Optional<Ingredients> findById(Integer id) {
        return ir.findById(id);
    }

    @Override
    public Ingredients save(Ingredients ingredients) {
        return ir.save(ingredients);
    }

    @Override
    public Ingredients update(Ingredients ingredients) {
        if(ir.findById(ingredients.getId()).isPresent()){
            return ir.save(ingredients);
        }
        return null;
    }

    @Override
    public Ingredients delete(Integer id) {
        Ingredients ingredients = findById(id).get();
        ir.delete(ingredients);
        return ingredients;
    }
}
