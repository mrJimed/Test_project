package com.company.project.web.screens.physicalperson;

import com.haulmont.cuba.gui.screen.*;
import com.company.project.entity.PhysicalPerson;

@UiController("project_PhysicalPerson.browse")
@UiDescriptor("physical-person-browse.xml")
@LookupComponent("physicalPersonsTable")
@LoadDataBeforeShow
public class PhysicalPersonBrowse extends StandardLookup<PhysicalPerson> {
}