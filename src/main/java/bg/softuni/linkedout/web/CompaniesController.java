package bg.softuni.linkedout.web;

import bg.softuni.linkedout.models.Company;
import bg.softuni.linkedout.models.dtos.CompanyRegisterDto;
import bg.softuni.linkedout.service.CompanyService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class CompaniesController {
    private final CompanyService companyService;

    public CompaniesController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("companies/add")
    public String addCompanyView(Model model){
        if (!model.containsAttribute("company")) {
            model.addAttribute("company", new CompanyRegisterDto());
        }
        return "company-add";
    }

    @PostMapping("companies/add")
    public String addCompany(@Valid CompanyRegisterDto companyRegisterDto, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("company", companyRegisterDto);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.company", bindingResult);
            return "redirect:/companies/add";
        }
        companyService.registerCompany(companyRegisterDto);
        return "redirect:/";
    }

    @GetMapping("/companies/all")
    public String viewAllCompanies(Model model){
        List<Company> allCompanies = companyService.getAllCompanies();
        model.addAttribute("companies", allCompanies);
        return "company-all";
    }
}
