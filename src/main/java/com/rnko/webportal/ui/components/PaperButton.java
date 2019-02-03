package com.rnko.webportal.ui.components;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;

@Tag("paper-button")
@HtmlImport("bower_components/paper-button/paper-button.html")
public class PaperButton extends Component {

    public PaperButton(String classButton, String text) {
        this.getElement().setAttribute("class", classButton);
        this.getElement().setAttribute("text", text);
    }
}
