package bg.softuni.linkedout.service;

import bg.softuni.linkedout.models.dtos.CompanyRegisterDto;

import java.util.List;

public interface CompanyService {
    void registerCompany(CompanyRegisterDto companyRegisterDto);
    List<String> getAllCompaniesNames();
}
