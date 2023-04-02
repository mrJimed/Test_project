package com.company.project.web.screens.repair;

import com.haulmont.cuba.gui.screen.*;
import com.company.project.entity.Repair;

@UiController("project_Repair.browse")
@UiDescriptor("repair-browse.xml")
@LookupComponent("repairsTable")
@LoadDataBeforeShow
public class RepairBrowse extends StandardLookup<Repair> {
}