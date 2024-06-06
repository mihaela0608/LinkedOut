package bg.softuni.linkedout.service.impl;

import bg.softuni.linkedout.models.Employee;
import bg.softuni.linkedout.models.dtos.EmployeeRegisterDto;
import bg.softuni.linkedout.repository.CompanyRepository;
import bg.softuni.linkedout.repository.EmployeeRepository;
import bg.softuni.linkedout.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;
    private final CompanyRepository companyRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ModelMapper modelMapper, CompanyRepository companyRepository) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
        this.companyRepository = companyRepository;
    }

    @Override
    public void registerEmployee(EmployeeRegisterDto employeeRegisterDto) {
        Employee employee = modelMapper.map(employeeRegisterDto, Employee.class);
        employee.setCompany(companyRepository.findByName(employeeRegisterDto.getCompany()).orElse(null));
        employeeRepository.saveAndFlush(employee);
    }
}
