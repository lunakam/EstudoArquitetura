package io.github.lunakam.estudoarquitetura.utils.hooks;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import lombok.extern.slf4j.Slf4j;


//codigo para executar Antes e Depois de rodar cada cenario
//funcao de logar quando o cenario comeca e quando ele termina


@Slf4j
public class LogHook {
    @Before
    public void startScenario(Scenario scenario) {
        log.info("Scenario {} started", scenario.getName());
    }

    @After
    public void endScenario(Scenario scenario){
        if(scenario.isFailed()) {
            log.error("Scenario {} finished with error", scenario.getName());
        } else {
            log.info("Scenario {} finished", scenario.getName());
        }
    }

}
