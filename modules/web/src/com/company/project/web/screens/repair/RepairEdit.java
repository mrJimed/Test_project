package com.company.project.web.screens.repair;

import com.company.project.entity.CarService;
import com.company.project.entity.Employee;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.gui.components.HasValue;
import com.haulmont.cuba.gui.components.LookupField;
import com.haulmont.cuba.gui.components.PickerField;
import com.haulmont.cuba.gui.screen.*;
import com.company.project.entity.Repair;

import javax.inject.Inject;
import java.util.List;

@UiController("project_Repair.edit")
@UiDescriptor("repair-edit.xml")
@EditedEntityContainer("repairDc")
@LoadDataBeforeShow
public class RepairEdit extends StandardEditor<Repair> {
    @Inject
    protected LookupField<Employee> employeeField;

    @Inject
    private DataManager dataManager;

    @Subscribe("carServiceField")
    protected void onCarServiceFieldValueChange(HasValue.ValueChangeEvent<CarService> event) {
        employeeField.clear();

        CarService carService = event.getValue();
        List<Employee> employees = dataManager.load(Employee.class)
                .query("select e from project_Employee e where e.carService = :carService")
                .parameter("carService", carService)
                .list();
        employeeField.setOptionsList(employees);
    }



//    @Subscribe("carServiceField")
//    protected void onCarServiceFieldValueChange(HasValue.ValueChangeEvent<CarService> event) {
//        employeeField.clear();
//
//        CarService carService = event.getValue();
//        List<Employee> employees = dataManager.load(Employee.class)
//                .query("select e from project_Employee e where e.carService = :carService")
//                .parameter("carService", carService)
//                .list();
//        employeeField.setOptionsList(employees);
//    }


}