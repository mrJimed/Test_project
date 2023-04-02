package com.company.project.entity;

import com.esotericsoftware.kryo.NotNull;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;

@Table(name = "PROJECT_REPAIR")
@Entity(name = "project_Repair")
public class Repair extends StandardEntity {
    private static final long serialVersionUID = -8682871924441247453L;

    @NotNull
    @Column(name = "NAME", nullable = false)
    private String name;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CAR_SERVICE_ID")
    private CarService carService;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EMPLOYEE_ID")
    private Employee employee;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CarService getCarService() {
        return carService;
    }

    public void setCarService(CarService carService) {
        this.carService = carService;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}