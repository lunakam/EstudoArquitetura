package io.github.lunakam.estudoarquitetura.stepsDefinition.components;

import io.github.lunakam.estudoarquitetura.drivers.WebDriverContext;
import io.github.lunakam.estudoarquitetura.pageObjects.BaseComponent;
import org.openqa.selenium.By;

public class DropdownComponent extends BaseComponent {
    public DropdownComponent(WebDriverContext webDriverContext) {
        super(webDriverContext);
    }

    public void select(By selector, String value) {
    }

    public void selectFirst(By selector) {

    }

    public void selectRandom(By selector) {

    }
}
