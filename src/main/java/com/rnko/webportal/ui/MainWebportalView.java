package com.rnko.webportal.ui;


import com.vaadin.flow.component.applayout.AbstractAppRouterLayout;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.AppLayoutMenu;
import com.vaadin.flow.component.applayout.AppLayoutMenuItem;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.VaadinIcon;


public class MainWebportalView extends AbstractAppRouterLayout {

    public MainWebportalView(){

    }
    @Override
    protected void configure(AppLayout appLayout, AppLayoutMenu menu) {
        appLayout.setBranding(new Span("RNKO WebPortal"));
        setMenuItem(menu, new AppLayoutMenuItem(VaadinIcon.HOME_O.create(), "HOME", "/issue"));

    }

    private void setMenuItem(AppLayoutMenu menu, AppLayoutMenuItem menuItem) {
        menuItem.getElement().setAttribute("theme", "icon-on-top");
        menu.addMenuItem(menuItem);
    }

}
