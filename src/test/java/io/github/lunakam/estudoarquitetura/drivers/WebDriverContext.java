package io.github.lunakam.estudoarquitetura.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class WebDriverContext {
    private WebDriver webDriver;
    private Wait<WebDriver> driverWait;
    private WebDriverPool webDriverPool;

    public WebDriverContext(WebDriverPool webDriverPool){
        this.webDriverPool = webDriverPool;
    }

    public WebDriver getDriver() {
        return webDriver;
    }

    public Wait<WebDriver> getDriverWait() {
        return driverWait;
    }

    public void initialize() {
        this.webDriver = webDriverPool.acquire();
        this.driverWait = new FluentWait<>(webDriver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(Exception.class);

        webDriver.manage().deleteAllCookies();
        webDriver.get("https://the-internet.herokuapp.com/login");
    }

    public void finalize() {
        webDriverPool.release(webDriver);
    }
}
