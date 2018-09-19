package io.github.lunakam.estudoarquitetura.stepsDefinition.components;

import io.github.lunakam.estudoarquitetura.drivers.WebDriverContext;
import io.github.lunakam.estudoarquitetura.pageObjects.BaseComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ByChained;

import java.util.List;
import java.util.stream.Collectors;

public class CrudTableList extends BaseComponent {

    private static final By ALL_TABLE_HEADERS = By.xpath("//thead/tr/th/span");
    private static final By ALL_TABLE_ROWS = By.xpath("//tbody/tr");

    public CrudTableList(WebDriverContext webDriverContext) {
        super(webDriverContext);
    }

    public List<String> getHeaderColumns(By selector){
        return helper
                .findElements(new ByChained(selector, ALL_TABLE_HEADERS))
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public List<WebElement> getRows(By selector){
        return helper.findElements(new ByChained(selector, ALL_TABLE_ROWS));
    }
}
