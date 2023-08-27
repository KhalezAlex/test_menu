package org.klozevitz.test_menu.model.dao.menu;

import lombok.RequiredArgsConstructor;
import org.klozevitz.test_menu.model.entities.menu.Menu;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MenuService implements IDaoMenu{

    final public MenuRepository repository;

    @Override
    public List<Menu> findAll() {
        return (List<Menu>) repository.findAll();
    }

    @Override
    public Optional<Menu> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Menu save(Menu menu) {
        return repository.save(menu);
    }

    @Override
    public Menu update(Menu menu) {
        Menu updated = repository.findById(menu.getId()).orElse(null);
        if (updated == null){
            return null;
        }
        updated.setCompany(menu.getCompany());
        return updated;
    }

    @Override
    public Menu delete(Integer id) {
        Menu menu = findById(id).get();
        repository.delete(menu);
        return menu;
    }
}
