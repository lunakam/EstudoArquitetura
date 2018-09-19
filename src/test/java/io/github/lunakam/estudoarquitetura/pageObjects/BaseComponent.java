package io.github.lunakam.estudoarquitetura.pageObjects;

import io.github.lunakam.estudoarquitetura.drivers.WebDriverContext;
import io.github.lunakam.estudoarquitetura.utils.SeleniumHelper;
import lombok.Getter;

public class BaseComponent {

    @Getter
    private final WebDriverContext webDriverContext;

    protected final SeleniumHelper helper;

    protected BaseComponent(WebDriverContext webDriverContext) {
        this.webDriverContext = webDriverContext;
        this.helper = new SeleniumHelper(webDriverContext);
    }
}
