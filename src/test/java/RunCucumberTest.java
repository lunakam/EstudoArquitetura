import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import io.github.lunakam.estudoarquitetura.drivers.MyDriver;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"}
        , features = {"src/test/resources/features"}
        , glue = {"io/github/lunakam/estudoarquitetura/stepsDefinition"})
public class RunCucumberTest {
}