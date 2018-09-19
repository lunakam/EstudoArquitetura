package io.github.lunakam.estudoarquitetura.pageObjects;

import io.github.lunakam.estudoarquitetura.drivers.WebDriverContext;
import io.github.lunakam.estudoarquitetura.stepsDefinition.components.AntdComponent;
import io.github.lunakam.estudoarquitetura.utils.SeleniumHelper;
import lombok.Getter;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class PageObject {

    @Getter
    private final WebDriverContext webDriverContext;

    protected final SeleniumHelper helper;

    protected final AntdComponent antd;

    protected PageObject(WebDriverContext webDriverContext) {
        this.webDriverContext = webDriverContext;
        this.helper = new SeleniumHelper(webDriverContext);
        this.antd = new AntdComponent(webDriverContext);
        AjaxElementLocatorFactory locatorFactory = new AjaxElementLocatorFactory(webDriverContext.getDriver(), 15);
        PageFactory.initElements(locatorFactory, this);
    }
}
