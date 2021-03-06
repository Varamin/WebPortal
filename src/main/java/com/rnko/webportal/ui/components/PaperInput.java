package com.rnko.webportal.ui.components;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.dependency.JavaScript;

//https://ruseller.com/lessons.php?id=2109
@Tag("paper-input")
@HtmlImport("bower_components/paper-input/paper-input.html")
public class PaperInput extends Component {

    public PaperInput(String label) {
        this.getElement().setAttribute("label", label);
    }

    public void setValue(String text) {
        this.getElement().setText(text);
    }
}
