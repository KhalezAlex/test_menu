package org.klozevitz.test_menu.model.dao.ingredients;

import lombok.RequiredArgsConstructor;
import org.klozevitz.test_menu.model.dao.IDaoDB;
import org.klozevitz.test_menu.model.entities.Menu.Ingredients;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IngredientsService implements IDaoDB<Ingredients> {

    private final IngredientsRepository ir;

    @Override
    public List<Ingredients> findAll() {
        return null;
    }

    @Override
    public Mono<Ingredients> findById(Integer id) {
        return null;
    }

    @Override
    public Ingredients save(Ingredients ingredients) {
        return null;
    }

    @Override
    public Ingredients update(Ingredients ingredients) {
        return null;
    }

    @Override
    public Ingredients delete(Integer id) {
        return null;
    }
}
