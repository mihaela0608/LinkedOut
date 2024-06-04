package bg.softuni.linkedout.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "companies")
public class Company extends BaseEntity{
    //budget – a number. (must be a positive number). Cannot be null.
    //
    //· description – a very long char sequence. Cannot be null. Must be at least 10 characters.
    //
    //· name – a char sequence. Must be unique and cannot be null. Must be between 2 and 10 characters.
    //
    //· town – a char sequence. Cannot be null. Must be between 2 and 10 characters.
    private Integer budget;
    @Column(columnDefinition = "TEXT")
    private String description;
    private String name;
    private String town;
    @OneToMany(mappedBy = "company")
    private List<Employee> employees;

    public Company() {
        this.employees = new ArrayList<>();
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Integer getBudget() {
        return budget;
    }

    public void setBudget(Integer budget) {
        this.budget = budget;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }
}
