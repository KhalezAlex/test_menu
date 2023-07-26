package org.klozevitz.test_menu.model.dao.company;

import org.klozevitz.test_menu.model.entities.Company;
import org.springframework.data.repository.CrudRepository;

public interface CompanyRepository extends CrudRepository<Company, Integer> {
}
