package com.rnko.webportal.ui.views;

import com.rnko.webportal.ui.MainWebportalView;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.templatemodel.TemplateModel;


@Route(value = "", layout = MainWebportalView.class)
@Tag("main-view")
@HtmlImport("src/views/main-view.html")
public class HomeView extends Div  {
    @Id("content")
    private Div content;

    /*public void setContent(Component content) {
        this.content.removeAll();
        this.content.add(content);
        HomeView page = new HomeView();
        page.setContent(new Label("Hello!"));
    }*/

    public HomeView() {
        add(new paperButton("ФИО"));
        add(new paperButton("Company"));
    }

}
