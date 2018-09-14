package io.github.lunakam.estudoarquitetura.utils.hooks;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.github.lunakam.estudoarquitetura.drivers.WebDriverContext;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

//funcao de configurar o webdriver para o cenario + Verificar se o cenario falhou e colocar o print da tela


public class WebDriverConfigHook {

    private WebDriverContext webDriverContext;

    public WebDriverConfigHook(WebDriverContext webDriverContext){
        this.webDriverContext = webDriverContext;
    }

    @Before
    public void startScenario() {
        webDriverContext.initialize();
    }

    @After
    public void endScenario(Scenario scenario){
        if (scenario.isFailed()) {
            scenario.embed(((TakesScreenshot)webDriverContext.getDriver()).getScreenshotAs(OutputType.BYTES), "image/png");
        }

        webDriverContext.finalize();
    }

}
