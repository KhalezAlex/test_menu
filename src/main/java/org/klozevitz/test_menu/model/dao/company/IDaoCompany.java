package org.klozevitz.test_menu.model.dao.company;

import org.klozevitz.test_menu.model.dao.IDaoDB;
import org.klozevitz.test_menu.model.entities.users.Company;

public interface IDaoCompany extends IDaoDB<Company> {
    Company findCompanyByName(String name);
}
