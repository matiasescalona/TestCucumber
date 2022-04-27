import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions (features="src/test/java/features/llenarFormulario.feature",glue= "steps")
public class RunTest  extends AbstractTestNGCucumberTests {
}
