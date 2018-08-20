package io.github.lunakam.estudoarquitetura.stepsDefinition;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import io.github.lunakam.estudoarquitetura.pageObjects.LoginPage;

@RunWith(Cucumber.class)
public class LoginSteps {
    LoginPage loginPage = new LoginPage();
    public String url = "https://the-internet.herokuapp.com/login";

    @Before
    public void setUp() {
        loginPage.openSite(url);
    }
    @After
    public void byeBye() {
        loginPage.closeSite();
    }

    @Given("^I have accessed the site$")
    public void i_have_accessed_the_site() {
        loginPage.PageInitialMessage();
    }

    @When("^I type \"([^\"]*)\" in email field$")
    public void iTypeInEmailField(String username)  {
        loginPage.fillUsername(username);
    }

    @And("^I type \"([^\"]*)\" in password field$")
    public void iTypeInPasswordField(String password) {
        loginPage.fillPassword(password);
    }

    @And("^I click 'Login'$")
    public void i_click_login() {
        loginPage.clickLoginButton();
    }

    @Then("^I should be redirect to the secure area$")
    public void i_should_be_redirect_to_the_secure_area() {
        loginPage.secureAreaMessage();
    }

}

