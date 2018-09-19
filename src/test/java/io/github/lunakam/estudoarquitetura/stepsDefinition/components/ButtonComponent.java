package io.github.lunakam.estudoarquitetura.stepsDefinition.components;

import io.github.lunakam.estudoarquitetura.drivers.WebDriverContext;
import io.github.lunakam.estudoarquitetura.pageObjects.BaseComponent;
import org.openqa.selenium.By;

public class ButtonComponent extends BaseComponent {
    public ButtonComponent(WebDriverContext webDriverContext) {
        super(webDriverContext);
    }

    public void click(By selector) {
        helper.waitForElement(selector).click();
    }

}
