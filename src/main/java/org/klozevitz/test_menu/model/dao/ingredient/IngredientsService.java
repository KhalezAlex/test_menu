package org.klozevitz.test_menu.model.dao.ingredient;

import lombok.RequiredArgsConstructor;
import org.klozevitz.test_menu.model.dao.IDaoDB;
import org.klozevitz.test_menu.model.entities.menu.Ingredient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class IngredientsService implements IDaoDB<Ingredient> {

    private final IngredientsRepository ir;


    @Override
    public List<Ingredient> findAll() {
        return (List<Ingredient>) ir.findAll();
    }

    @Override
    public Optional<Ingredient> findById(Integer id) {
        return ir.findById(id);
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        return ir.save(ingredient);
    }

    @Override
    public Ingredient update(Ingredient ingredient) {
        if(ir.findById(ingredient.getId()).isPresent()){
            return ir.save(ingredient);
        }
        return null;
    }

    @Override
    public Ingredient delete(Integer id) {
        Ingredient ingredient = findById(id).get();
        ir.delete(ingredient);
        return ingredient;
    }
}
