package bg.softuni.linkedout.service.impl;

import bg.softuni.linkedout.models.Employee;
import bg.softuni.linkedout.models.dtos.EmployeeRegisterDto;
import bg.softuni.linkedout.repository.CompanyRepository;
import bg.softuni.linkedout.repository.EmployeeRepository;
import bg.softuni.linkedout.service.EmployeeService;
import bg.softuni.linkedout.util.LastUpdated;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;
    private final CompanyRepository companyRepository;
    private final LastUpdated lastUpdated;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ModelMapper modelMapper, CompanyRepository companyRepository, LastUpdated lastUpdated) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
        this.companyRepository = companyRepository;
        this.lastUpdated = lastUpdated;
    }

    @Override
    public void registerEmployee(EmployeeRegisterDto employeeRegisterDto) {
        Employee employee = modelMapper.map(employeeRegisterDto, Employee.class);
        employee.setCompany(companyRepository.findByName(employeeRegisterDto.getCompany()).orElse(null));
        employeeRepository.saveAndFlush(employee);
        lastUpdated.setLastUpdate(LocalDateTime.now());
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }
}
