package com.company.project.entity;

import com.esotericsoftware.kryo.NotNull;
import com.haulmont.chile.core.annotations.Composition;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.OnDeleteInverse;
import com.haulmont.cuba.core.global.DeletePolicy;
import com.haulmont.cuba.security.entity.User;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Table(name = "PROJECT_CAR_SERVICE")
@Entity(name = "project_CarService")
@NamePattern("%s |name")
public class CarService extends StandardEntity {
    private static final long serialVersionUID = -4056562528429833796L;

    @NotNull
    @Column(name = "NAME", nullable = false)
    private String name;

    @NotNull
    @Column(name = "ADDRESS", nullable = false)
    private String address;

    @NotNull
    @Column(name = "PHONE_NUMBER", nullable = false)
    private String phoneNumber;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDeleteInverse(DeletePolicy.DENY)
    @JoinColumn(name = "CITY_ID")
    private City city;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "carService")
    @Composition
    private List<Employee> employees;

    @ManyToMany
    @JoinTable(name = "TEST_CLIENT_LINK",
            joinColumns = @JoinColumn(name = "CAR_SERVICE_ID"),
            inverseJoinColumns = @JoinColumn(name = "CLIENT_ID"))
    private Set<Client> clients;

    @Column(name = "CREATED_BY", length = 50)
    private String createdBy;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }

    @Override
    public String getCreatedBy() {
        return createdBy;
    }

    @Override
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
}