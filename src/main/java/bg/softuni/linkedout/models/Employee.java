package bg.softuni.linkedout.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "employees")
public class Employee extends BaseEntity {
    //birthdate – a date. Cannot be null.
    //
    //· educationLevel – a char sequence. Cannot be null.
    //
    //· firstName – a char sequence. Cannot be null. Must be at least 2 characters. Cannot be null.
    //
    //· jobTitle – a char sequence. Cannot be null.
    //
    //· lastName – a char sequence. Cannot be null. Must be at least 2 characters. Cannot be null.
    //
    //· salary – a number (must be a positive number). Cannot be null.
    private LocalDate birthdate;
    @Column(name = "education_level")
    private String educationLevel;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "job_title")
    private String jobTitle;
    @Column(name = "last_name")
    private String lastName;
    private Integer salary;
    @ManyToOne
    private Company company;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }
}
