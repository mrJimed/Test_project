package com.company.project.web.screens.carservice;

import com.haulmont.cuba.gui.screen.*;
import com.company.project.entity.CarService;

@UiController("project_CarService.browse")
@UiDescriptor("car-service-browse.xml")
@LookupComponent("carServicesTable")
@LoadDataBeforeShow
public class CarServiceBrowse extends StandardLookup<CarService> {
}