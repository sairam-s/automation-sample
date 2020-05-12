import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        monochrome = true,
        features = {"classpath:features/"},
        glue = {"com.automation.steps"}
)

public class CucumberTestNGRunner extends AbstractTestNGCucumberTests {

}
