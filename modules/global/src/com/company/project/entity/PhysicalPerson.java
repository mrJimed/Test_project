package com.company.project.entity;

import com.esotericsoftware.kryo.NotNull;
import com.haulmont.cuba.core.entity.StandardEntity;
import org.checkerframework.checker.index.qual.Positive;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "PROJECT_PHYSICAL_PERSON")
@Entity(name = "project_PhysicalPerson")
public class PhysicalPerson extends Client {
    private static final long serialVersionUID = -4702414473389338392L;

    @NotNull
    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;

    @NotNull
    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;

    @NotNull
    @Positive
    @Column(name = "AGE", nullable = false)
    private Integer age;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}