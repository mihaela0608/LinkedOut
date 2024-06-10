package bg.softuni.linkedout.web;

import bg.softuni.linkedout.models.dtos.EmployeeRegisterDto;
import bg.softuni.linkedout.service.CompanyService;
import bg.softuni.linkedout.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private final CompanyService companyService;
    private final EmployeeService employeeService;

    public EmployeeController(CompanyService companyService, EmployeeService employeeService) {
        this.companyService = companyService;
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public String addEmployeeView(Model model){
        if (!model.containsAttribute("employeeRegisterDto")){
            model.addAttribute("employeeRegisterDto", new EmployeeRegisterDto());
        }
        model.addAttribute("companies", companyService.getAllCompaniesNames());
       return "employee-add";
    }

    @PostMapping("/add")
    public String addEmployee(@Valid EmployeeRegisterDto employeeRegisterDto, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            System.out.println(employeeRegisterDto.getLastName()+ employeeRegisterDto.getBirthdate()+ employeeRegisterDto.getCompany()+ employeeRegisterDto.getFirstName()+ employeeRegisterDto.getSalary()+employeeRegisterDto.getJobTitle() + employeeRegisterDto.getEducationLevel());
            //TODO: Make a service for registration of an employee meke the logic in both get and post mappings, Make it with error messages
            redirectAttributes.addFlashAttribute("employeeRegisterDto", employeeRegisterDto);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.employeeRegisterDto", bindingResult);
            return "redirect:/employees/add";
        }
        employeeService.registerEmployee(employeeRegisterDto);
        return "redirect:/";
    }

    @GetMapping("/all")
    public String viewAllEmployees(Model model){
        model.addAttribute("employees", employeeService.getAll());
        return "employee-all";
    }
}
