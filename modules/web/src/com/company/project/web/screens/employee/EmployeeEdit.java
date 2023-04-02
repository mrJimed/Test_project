package com.company.project.web.screens.employee;

import com.haulmont.cuba.gui.screen.*;
import com.company.project.entity.Employee;

@UiController("project_Employee.edit")
@UiDescriptor("employee-edit.xml")
@EditedEntityContainer("employeeDc")
@LoadDataBeforeShow
public class EmployeeEdit extends StandardEditor<Employee> {
}