package org.klozevitz.test_menu.model.dao.profile;

import org.klozevitz.test_menu.model.entities.entity.Profile;
import org.springframework.data.repository.CrudRepository;

public interface ProfileRepository extends CrudRepository<Profile, Integer> {
}
