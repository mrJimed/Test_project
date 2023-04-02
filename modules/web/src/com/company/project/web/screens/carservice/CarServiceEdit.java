package com.company.project.web.screens.carservice;

import com.company.project.entity.Client;
import com.company.project.entity.LegalPerson;
import com.company.project.entity.PhysicalPerson;
import com.company.project.service.CityService;
import com.haulmont.cuba.core.global.Messages;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.components.TabSheet;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.screen.*;
import com.company.project.entity.CarService;

import javax.inject.Inject;
import java.util.Set;

@UiController("project_CarService.edit")
@UiDescriptor("car-service-edit.xml")
@EditedEntityContainer("carServiceDc")
@LoadDataBeforeShow
public class CarServiceEdit extends StandardEditor<CarService> {
    @Inject
    protected CityService cityService;

    @Inject
    protected Messages messages;

    @Inject
    private TabSheet tabSheet;

    @Subscribe
    protected void onInitEntity(InitEntityEvent<CarService> event) {
        CarService carService = event.getEntity();
        if(carService.getCity() == null)
            carService.setCity(cityService.getDefaultCity());
    }

    private void ShowCountClients(Set<Client> clients) {
        int count = (clients == null) ? 0 : clients.size();
        String tabText =messages.getMessage(CarServiceEdit.class, "clientsTab");
        tabSheet.getTab("clientsTab").setCaption(tabText + " (" + count + ")");
    }

    @Subscribe(id = "carServiceDc", target = Target.DATA_CONTAINER)
    protected void onCarServiceDcItemPropertyChange(InstanceContainer.ItemPropertyChangeEvent<CarService> event) {
        ShowCountClients(event.getItem().getClients());
    }

    @Subscribe(id = "carServiceDc", target = Target.DATA_CONTAINER)
    protected void onCarServiceDcItemChange(InstanceContainer.ItemChangeEvent<CarService> event) {
        ShowCountClients(event.getItem().getClients());
    }

    @Install(to = "clientsTable.type", subject = "columnGenerator")
    private Component tableGeneratedColumnFullNameColumnGenerator(Client client) {
        String key = client.getClass().getSimpleName();
        if(client instanceof LegalPerson)
            return new Table.PlainTextCell(messages.getMessage(LegalPerson.class, key));
        else
            return new Table.PlainTextCell(messages.getMessage(PhysicalPerson.class, key));
    }
}