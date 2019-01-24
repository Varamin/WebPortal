package com.rnko.webportal.ui.views;

import com.rnko.webportal.ui.MainWebportalView;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.templatemodel.TemplateModel;

@Route(value = "", layout = MainWebportalView.class)
@Tag("main-view")
@HtmlImport("src/views/main-view.html")
public class HomeView extends PolymerTemplate<TemplateModel> {

    public HomeView() {

    }

}
