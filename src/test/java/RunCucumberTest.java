import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import io.github.lunakam.estudoarquitetura.drivers.MyDriver;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:target/cucumber-html-report/login", "json:target/cucumber-json-report/login.json"}
        , features = {"src/test/resources/features"}
        , glue = {"io/github/lunakam/estudoarquitetura/stepsDefinition"}
        , tags = {"not @ignore"})
public class RunCucumberTest {
}