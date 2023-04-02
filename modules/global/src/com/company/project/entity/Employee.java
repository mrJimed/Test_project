package com.company.project.entity;

import com.esotericsoftware.kryo.NotNull;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "PROJECT_EMPLOYEE")
@Entity(name = "project_Employee")
@NamePattern("%s %s |firstName, lastName")
public class Employee extends StandardEntity {
    private static final long serialVersionUID = 5431800602488073354L;

    @NotNull
    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;

    @NotNull
    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;

    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "BIRTHDAY", nullable = false)
    private Date birthday;

    @NotNull
    @Column(name = "SALARY", nullable = false)
    private BigDecimal salary;

    @NotNull
    @Email
    @Column(name = "EMAIL", nullable = false)
    private String email;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CAR_SERVICE_ID")
    private CarService carService;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public CarService getCarService() {
        return carService;
    }

    public void setCarService(CarService carService) {
        this.carService = carService;
    }
}