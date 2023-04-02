package com.company.project.core.role;

import com.company.project.entity.CarService;
import com.company.project.entity.City;
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

@Role(name = CarServiceManagerRole.NAME)
public class CarServiceManagerRole extends AnnotatedRoleDefinition {
    public final static String NAME = "car-service-manager";

    @ScreenAccess(screenIds = { "application-project", "project_CarService.browse", "project_CarService.edit", "project_City.browse", "project_Client.browse", "project_Employee.edit" })
    @Override
    public ScreenPermissionsContainer screenPermissions() {
        return super.screenPermissions();
    }

    @EntityAccess(entityClass = CarService.class, operations = { EntityOp.READ, EntityOp.UPDATE, EntityOp.CREATE })
    @EntityAccess(entityClass = Client.class, operations = { EntityOp.READ })
    @EntityAccess(entityClass = City.class, operations = { EntityOp.READ })
    @EntityAccess(entityClass = Employee.class, operations = { EntityOp.READ, EntityOp.CREATE })
    @Override
    public EntityPermissionsContainer entityPermissions() {
        return super.entityPermissions();
    }

    @EntityAttributeAccess(entityClass = CarService.class, modify = { "address", "city", "clients", "employees", "name", "phoneNumber" } )
    @EntityAttributeAccess(entityClass = Client.class, view = { "email" } )
    @EntityAttributeAccess(entityClass = City.class, view = { "name", "phoneCode", "isDefaultCity" })
    @EntityAttributeAccess(entityClass = Employee.class, modify = { "firstName", "lastName", "email", "salary", "birthday" } )
    @Override
    public EntityAttributePermissionsContainer entityAttributePermissions() {
        return super.entityAttributePermissions();
    }
}
