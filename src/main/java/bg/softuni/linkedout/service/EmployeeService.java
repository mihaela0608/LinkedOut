package bg.softuni.linkedout.service;

import bg.softuni.linkedout.models.Employee;
import bg.softuni.linkedout.models.dtos.EmployeeRegisterDto;

import java.util.List;

public interface EmployeeService {
    void registerEmployee(EmployeeRegisterDto employeeRegisterDto);
    List<Employee> getAll();
}
