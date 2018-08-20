package io.github.lunakam.estudoarquitetura.drivers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class MyDriver {

    private static WebDriver driver;

    static {
        System.setProperty("webdriver.chrome.driver", MyDriver.class.getClassLoader().getResource("chromedriver").getFile());
        driver = new org.openqa.selenium.chrome.ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public static WebElement findElementId(String elementId) {
        return driver.findElement(By.id(elementId));
    }

    public static WebElement findElementClassName(String elementClassName) {
        return driver.findElement(By.className(elementClassName));
    }

    public static void clearField(String element) {
        findElementId(element).clear();
    }

    public static void sendKeys(String element, String value) {
        findElementId(element).sendKeys(value);
    }


    public static void click(String element) {
        findElementClassName(element).click();
    }

    public static void close() {
        driver.close();
    }

    public static void get(String url) {
        driver.get(url);
    }
}
