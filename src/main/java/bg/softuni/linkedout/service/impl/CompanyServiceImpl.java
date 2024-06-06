package bg.softuni.linkedout.service.impl;

import bg.softuni.linkedout.models.Company;
import bg.softuni.linkedout.models.dtos.CompanyRegisterDto;
import bg.softuni.linkedout.repository.CompanyRepository;
import bg.softuni.linkedout.service.CompanyService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;
    private final ModelMapper modelMapper;


    public CompanyServiceImpl(CompanyRepository companyRepository, ModelMapper modelMapper) {
        this.companyRepository = companyRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional
    public void registerCompany(CompanyRegisterDto companyRegisterDto) {
        Company company = modelMapper.map(companyRegisterDto, Company.class);
        companyRepository.saveAndFlush(company);
    }

    @Override
    public List<String> getAllCompaniesNames() {
        List<String> companies = companyRepository.findAll().stream().map(c -> c.getName()).collect(Collectors.toList());
        return companies;
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }
}
