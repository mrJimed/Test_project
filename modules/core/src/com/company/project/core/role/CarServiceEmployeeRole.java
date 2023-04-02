package com.company.project.core.role;

import com.company.project.entity.CarService;
import com.company.project.entity.Client;
import com.company.project.entity.Employee;
import com.haulmont.cuba.security.app.role.AnnotatedRoleDefinition;
import com.haulmont.cuba.security.app.role.annotation.EntityAccess;
import com.haulmont.cuba.security.app.role.annotation.EntityAttributeAccess;
import com.haulmont.cuba.security.app.role.annotation.Role;
import com.haulmont.cuba.security.app.role.annotation.ScreenAccess;
import com.haulmont.cuba.security.entity.EntityOp;
import com.haulmont.cuba.security.role.EntityAttributePermissionsContainer;
import com.haulmont.cuba.security.role.EntityPermissionsContainer;
import com.haulmont.cuba.security.role.ScreenPermissionsContainer;

@Role(name = CarServiceEmployeeRole.NAME)
public class CarServiceEmployeeRole extends AnnotatedRoleDefinition {
    public final static String NAME = "car-service-employee";

    @EntityAccess(entityClass = CarService.class, operations = { EntityOp.READ })
    @EntityAccess(entityClass = Client.class, operations = { EntityOp.READ })
    @EntityAccess(entityClass = Employee.class, operations = { EntityOp.READ })
    @Override
    public EntityPermissionsContainer entityPermissions() {
        return super.entityPermissions();
    }

    @ScreenAccess(screenIds = {"application-project", "project_CarService.browse", "project_CarService.edit"})
    @Override
    public ScreenPermissionsContainer screenPermissions() {
        return super.screenPermissions();
    }

    @EntityAttributeAccess(entityClass = CarService.class, view = { "address", "city", "clients", "employees", "name", "phoneNumber" } )
    @EntityAttributeAccess(entityClass = Client.class, view = { "email" } )
    @EntityAttributeAccess(entityClass = Employee.class, view = { "firstName", "lastName", "email", "salary", "birthday" } )
    @Override
    public EntityAttributePermissionsContainer entityAttributePermissions() {
        return super.entityAttributePermissions();
    }
}
