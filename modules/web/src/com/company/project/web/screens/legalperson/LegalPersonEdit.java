package com.company.project.web.screens.legalperson;

import com.haulmont.cuba.gui.screen.*;
import com.company.project.entity.LegalPerson;

@UiController("project_LegalPerson.edit")
@UiDescriptor("legal-person-edit.xml")
@EditedEntityContainer("legalPersonDc")
@LoadDataBeforeShow
public class LegalPersonEdit extends StandardEditor<LegalPerson> {
}