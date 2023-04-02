package com.company.project.entity;

import com.esotericsoftware.kryo.NotNull;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Set;

@Table(name = "PROJECT_CLIENT")
@Entity(name = "project_Client")
@Inheritance(strategy = InheritanceType.JOINED)
@NamePattern("%s |email")
public class Client extends StandardEntity {
    private static final long serialVersionUID = 4731356763618130351L;

    @NotNull
    @Email
    @Column(name = "EMAIL", nullable = false)
    private String email;

    @ManyToMany(mappedBy = "clients")
    private Set<CarService> carServices;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<CarService> getCarServices() {
        return carServices;
    }

    public void setCarServices(Set<CarService> carServices) {
        this.carServices = carServices;
    }
}