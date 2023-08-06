package org.klozevitz.test_menu.model.dao.company;

import org.klozevitz.test_menu.model.entities.users.Company;
import org.springframework.data.repository.CrudRepository;

public interface CompanyRepository extends CrudRepository<Company, Integer> {
    Company findByName(String name);
//    Integer findIdByName(String name);
}
