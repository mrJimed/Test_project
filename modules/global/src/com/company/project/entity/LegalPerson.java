package com.company.project.entity;

import com.esotericsoftware.kryo.NotNull;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "PROJECT_LEGAL_PERSON")
@Entity(name = "project_LegalPerson")
public class LegalPerson extends Client {
    private static final long serialVersionUID = 9081858384398782810L;

    @NotNull
    @Column(name = "NAME", nullable = false)
    private String name;

    @NotNull
    @Column(name = "FIELD_ACTIVITY", nullable = false)
    private String fieldActivity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFieldActivity() {
        return fieldActivity;
    }

    public void setFieldActivity(String fieldActivity) {
        this.fieldActivity = fieldActivity;
    }
}