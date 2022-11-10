package org.vaadin.example;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

/**
 * A sample Vaadin view class.
 */
@Route
public class MainView extends VerticalLayout {

    public MainView(@Autowired GreetService service) {

        setWidth("300px");
        getStyle().set("margin", "0 auto");

        TextField nameField = createTextField("Enter name", "name", false);
        TextField lastNameField = createTextField("Enter lastname", "lastname", false);
        TextField ageField = createTextField("Enter age", "age", false);

        H1 h1 = new H1("Welcome to DX Tests");

        TextField nameFieldValue = createTextField("Name:", "nameValue", true);
        TextField lastNameFieldValue = createTextField("Lastname:", "lastnameValue", true);
        TextField ageFieldValue = createTextField("Age:", "ageValue", true);

        FormLayout formLayout = new FormLayout();
        formLayout.add(nameField, lastNameField, ageField);

        Paragraph serviceResponse = new Paragraph("");

        Button button = new Button("Submit",
                e -> {
                    nameFieldValue.setValue(nameField.getValue());
                    lastNameFieldValue.setValue(lastNameField.getValue());
                    ageFieldValue.setValue(String.valueOf(ageField.getValue()));
                    serviceResponse.setText(service.greet(nameField.getValue()));
                });
        button.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        button.addClickShortcut(Key.ENTER);

        formLayout.add(button);
        formLayout.add(nameFieldValue, lastNameFieldValue, ageFieldValue);

        add(h1, formLayout, serviceResponse);
    }

    private TextField createTextField(String label, String id, boolean readOnly) {
        TextField field = new TextField(label);
        field.setId(id);
        field.setReadOnly(readOnly);
        return field;
    }

}
