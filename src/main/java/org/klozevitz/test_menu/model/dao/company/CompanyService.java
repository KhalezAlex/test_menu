package org.klozevitz.test_menu.model.dao.company;

import lombok.RequiredArgsConstructor;
import org.klozevitz.test_menu.model.entities.users.Company;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class CompanyService implements IDaoCompany {

    private final CompanyRepository repository;

    @Override
    public List<Company> findAll() {
        return (List<Company>) repository.findAll();
    }

    @Override
    public Optional<Company> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Company save(Company company) {
        return repository.save(company);
    }

    @Override
    public Company update(Company company) {
        if(repository.findById(company.getId()).isPresent()){
            return repository.save(company);
        }
        return null;
    }

    @Override
    public Company delete(Integer id) {
        Company company = findById(id).get();
        repository.delete(company);
        return company;
    }

    @Override
    public Company findCompanyByName(String name) {
        return null;
    }
}
