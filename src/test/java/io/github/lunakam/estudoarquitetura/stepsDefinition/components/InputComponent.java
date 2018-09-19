package io.github.lunakam.estudoarquitetura.stepsDefinition.components;

import io.github.lunakam.estudoarquitetura.drivers.WebDriverContext;
import io.github.lunakam.estudoarquitetura.pageObjects.BaseComponent;
import org.openqa.selenium.By;

public class InputComponent extends BaseComponent {
    public InputComponent(WebDriverContext webDriverContext) {
        super(webDriverContext);
    }

    public void value(By selector, String value) {

    }


}
