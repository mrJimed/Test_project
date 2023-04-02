package com.company.project.entity;

import com.esotericsoftware.kryo.NotNull;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "PROJECT_CITY")
@Entity(name = "project_City")
@NamePattern("%s |name")
public class City extends StandardEntity {
    private static final long serialVersionUID = -7453295028117616612L;

    @NotNull
    @Column(name = "NAME", nullable = false, unique = true)
    private String name;

    @NotNull
    @Column(name = "PHONE_CODE", nullable = false)
    private String phoneCode;

    @Column(name = "IS_DEFAULT_CITY")
    private Boolean isDefaultCity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneCode() {
        return phoneCode;
    }

    public void setPhoneCode(String phoneCode) {
        this.phoneCode = phoneCode;
    }

    public Boolean getIsDefaultCity() {
        return isDefaultCity;
    }

    public void setIsDefaultCity(Boolean defaultCity) {
        isDefaultCity = defaultCity;
    }
}