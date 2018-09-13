package io.github.lunakam.estudoarquitetura.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverPool {

    private static WebDriver webDriver;

    static {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> webDriver.quit()));
    }

    public WebDriver acquire() {
        if(webDriver != null){
            return webDriver;
        }
        WebDriverManager.chromedriver()
                .setup();
        return webDriver = new ChromeDriver();
    }

    public void release(WebDriver webDriver) {

    }

}
