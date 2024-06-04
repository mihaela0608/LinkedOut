package bg.softuni.linkedout.models.dtos;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public class CompanyRegisterDto {

    @NotNull
    @Positive
    private Integer budget;
    @NotNull
    @Size(min = 10)
    private String description;
    @Size(min = 2, max = 10)
    @NotNull
    //TODO: unique too
    private String name;
    @Size(min = 2, max = 10)
    @NotNull
    private String town;

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
