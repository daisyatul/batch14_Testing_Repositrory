package StepDef;

import io.cucumber.java.*;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.BaseTest;
import utils.TestContext;

@Log4j2
public class HooksStepDef extends BaseTest {

    TestContext testContext;

    public HooksStepDef(TestContext testContext) {
        this.testContext = testContext;
    }

    //WebDriver driver;
    Scenario scenario;


    @Before  //native dependency injection in cucumber
    public void setUp(Scenario scenario) {
        this.scenario = scenario;
        scenario.log("Before each step");
    }

    @After
    public void cleanUp() {
        if (!(testContext.getDriver() == null)) {
            testContext.getDriver().quit();
        }
        scenario.log("After each step");
    }


    @AfterStep
    public void afterEachStep() {
        // if (scenario.isFailed()) {
        if (!(testContext.getDriver() == null)) {
            TakesScreenshot scrnShot = (TakesScreenshot) testContext.getDriver();
            byte[] data = scrnShot.getScreenshotAs(OutputType.BYTES);
            scenario.attach(data, "image/png", "Step Name: " + scenario.getName());
        }
        log.debug("Each step hook is executed, Screen shot taken");

        // scenario.log("After each step");

    }
}
