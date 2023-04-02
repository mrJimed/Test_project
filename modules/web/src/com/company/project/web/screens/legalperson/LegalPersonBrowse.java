package com.company.project.web.screens.legalperson;

import com.haulmont.cuba.gui.screen.*;
import com.company.project.entity.LegalPerson;

@UiController("project_LegalPerson.browse")
@UiDescriptor("legal-person-browse.xml")
@LookupComponent("legalPersonsTable")
@LoadDataBeforeShow
public class LegalPersonBrowse extends StandardLookup<LegalPerson> {
}