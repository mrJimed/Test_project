package com.company.project.web.screens.client;

import com.company.project.entity.LegalPerson;
import com.company.project.entity.PhysicalPerson;
import com.haulmont.cuba.core.global.Messages;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.screen.*;
import com.company.project.entity.Client;

import javax.inject.Inject;

@UiController("project_Client.browse")
@UiDescriptor("client-browse.xml")
@LookupComponent("clientsTable")
@LoadDataBeforeShow
public class ClientBrowse extends StandardLookup<Client> {
    @Inject
    protected Messages messages;

    @Install(to = "clientsTable.type", subject = "columnGenerator")
    private Component tableGeneratedColumnFullNameColumnGenerator(Client client) {
        String key = client.getClass().getSimpleName();
        if(client instanceof LegalPerson)
            return new Table.PlainTextCell(messages.getMessage(LegalPerson.class, key));
        else
            return new Table.PlainTextCell(messages.getMessage(PhysicalPerson.class, key));
    }
}