package org.klozevitz.test_menu.model.dao.profile;

import lombok.RequiredArgsConstructor;
import org.klozevitz.test_menu.model.dao.IDaoDB;
import org.klozevitz.test_menu.model.entities.users.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfileService implements IDaoProfile {
    private final ProfileRepository repository;

    @Override
    public List<Profile> findAll() {
        return (List<Profile>) repository.findAll();
    }

    @Override
    public Optional<Profile> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Profile save(Profile profile) {
        return repository.save(profile);
    }

    @Override
    @Transactional
    public Profile update(Profile profile) {
        Profile updated = repository.findById(profile.getId()).orElse(null);
        if (updated == null){
            return null;
        }
        updated.setCompany(profile.getCompany());
        return updated;
    }

    @Override
    public Profile delete(Integer id) {
        return null;
    }
}
