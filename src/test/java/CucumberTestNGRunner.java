
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterClass;

import java.io.File;


//@RunWith(Cucumber.class)
@CucumberOptions(
        monochrome = true,
        features = {"classpath:features/"},
        glue = {"com.automation.steps","com.automation.utils"},
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)

public class CucumberTestNGRunner extends AbstractTestNGCucumberTests {

}
