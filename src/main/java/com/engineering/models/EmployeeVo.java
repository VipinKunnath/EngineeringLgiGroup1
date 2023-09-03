package com.engineering.models;

import java.math.BigDecimal;
import java.sql.Date;


public class EmployeeVo {

    private String name;
    private Date dateOfJoining;
    private BigDecimal salary;
    private BigDecimal gemsAwarded;

    public Date getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(Date dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public BigDecimal getGemsAwarded() {
        return gemsAwarded;
    }

    public void setGemsAwarded(BigDecimal gemsAwarded) {
        this.gemsAwarded = gemsAwarded;
    }
}
