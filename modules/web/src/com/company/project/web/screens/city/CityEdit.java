package com.company.project.web.screens.city;

import com.company.project.service.CityService;
import com.haulmont.cuba.core.app.DataService;
import com.haulmont.cuba.core.global.CommitContext;
import com.haulmont.cuba.core.global.LoadContext;
import com.haulmont.cuba.gui.components.HasValue;
import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.screen.*;
import com.company.project.entity.City;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@UiController("project_City.edit")
@UiDescriptor("city-edit.xml")
@EditedEntityContainer("cityDc")
@LoadDataBeforeShow
public class CityEdit extends StandardEditor<City> {
    @Inject
    protected CityService cityService;

    @Inject
    protected DataService dataService;


    @Subscribe("isDefaultCityField")
    protected void onIsDefaultCityFieldValueChange(HasValue.ValueChangeEvent<Boolean> event) {
//        1-й способ
//        if (event.getValue())
//            cityService.resetDefaultCity(this.getEditedEntity());

//        2-й способ
//        if(event.getValue()) {
//            List<City> cities = dataService.loadList(new LoadContext<>(City.class)).stream().filter(City::getIsDefaultCity).collect(Collectors.toList());
//            cities.forEach(city -> city.setIsDefaultCity(false));
//            dataService.commit(new CommitContext(cities));
//        }
    }
}