package bg.softuni.linkedout.web;

import bg.softuni.linkedout.models.dtos.EmployeeRegisterDto;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class EmployeeController {
    @GetMapping("employees/add")
    public String addEmployeeView(){
       return "employee-add";
    }

    @PostMapping("employees/add")
    public String addEmployee(@Valid EmployeeRegisterDto employeeRegisterDto, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
           // System.out.println(employeeRegisterDto.getLastName()+ employeeRegisterDto.getBirthdate()+ employeeRegisterDto.getCompany()+ employeeRegisterDto.getFirstName()+ employeeRegisterDto.getSalary()+employeeRegisterDto.getJobTitle() + employeeRegisterDto.getEducationLevel());
            //TODO: Make a service for registration of an employee meke the logic in both get and post mappings, Make it with error messages
            return "index";
        }

        return "company-add";
    }
}
