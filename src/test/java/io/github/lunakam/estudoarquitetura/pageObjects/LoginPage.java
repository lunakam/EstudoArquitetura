package io.github.lunakam.estudoarquitetura.pageObjects;

import io.github.lunakam.estudoarquitetura.drivers.MyDriver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage {
    @FindBy(id="username")
    private WebElement username;


    public void fillUsername(String username) {
        MyDriver.clearField("username");
        MyDriver.sendKeys("username", username);
    }

    public void fillPassword(String password) {
        MyDriver.clearField("password");
        MyDriver.sendKeys("password", password);
    }

    public void clickLoginButton() {
        MyDriver.click("radius");
    }

    public void openSite(String url) {
        MyDriver.get(url);
    }

    public void closeSite() {
        MyDriver.close();
    }

    public void PageInitialMessage() {
        Assert.assertEquals("Login Page", MyDriver.findElementClassName("example").getAttribute("innerText").split("\n")[0]);
    }

    public void secureAreaMessage() {
        Assert.assertEquals("Secure Area", MyDriver.findElementClassName("example").getAttribute("innerText").split("\n")[1]);
    }


}
