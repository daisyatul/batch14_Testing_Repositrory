package Runner;
import StepDef.StepDef;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.testng.annotations.DataProvider;

@CucumberOptions(
            features = "classpath:features",
            glue = "StepDef",
            tags = "@LogIn",
            plugin = {"pretty",
                    "html:target/cucumber-reports.html",
                    "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
            },
            dryRun = false
    )
    public class AnyName extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

    }


