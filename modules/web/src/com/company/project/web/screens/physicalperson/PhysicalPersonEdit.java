package com.company.project.web.screens.physicalperson;

import com.haulmont.cuba.gui.screen.*;
import com.company.project.entity.PhysicalPerson;

@UiController("project_PhysicalPerson.edit")
@UiDescriptor("physical-person-edit.xml")
@EditedEntityContainer("physicalPersonDc")
@LoadDataBeforeShow
public class PhysicalPersonEdit extends StandardEditor<PhysicalPerson> {
}