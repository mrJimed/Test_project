package com.company.project.web.screens.city;

import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import com.company.project.entity.City;

import javax.inject.Inject;

@UiController("project_City.browse")
@UiDescriptor("city-browse.xml")
@LookupComponent("citiesTable")
@LoadDataBeforeShow
public class CityBrowse extends StandardLookup<City> {
    @Inject
    protected CollectionLoader<City> citiesDl;

    @Install(to = "citiesTable.edit", subject = "afterCloseHandler")
    protected void citiesTableEditAfterCloseHandler(AfterCloseEvent afterCloseEvent) {
        citiesDl.load();
    }

    @Install(to = "citiesTable.create", subject = "afterCloseHandler")
    protected void citiesTableCreateAfterCloseHandler(AfterCloseEvent afterCloseEvent) {
        citiesDl.load();
    }
}