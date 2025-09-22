package hooks;
import com.aventstack.extentreports.ExtentTest;
import reporting.ExtentManager;
import reporting.ExtentTestManager;
import io.cucumber.java.*;

public class Hooks {

    @Before
    public void beforeScenario(Scenario scenario) {
        // create an extent test for this scenario
        ExtentTestManager.createTest(scenario.getName());
        ExtentTestManager.getTest().info("Scenario started: " + scenario.getName());
        ExtentTestManager.getTest().info("Tags: " + scenario.getSourceTagNames());
    }

    @AfterStep
    public void afterStep(Scenario scenario) {
        // NOTE: Cucumber doesn't expose the step text reliably in AfterStep,
        // so prefer explicit logging inside step definitions for full detail.
        if (scenario.isFailed()) {
            ExtentTestManager.getTest().fail("A step failed in scenario.");
        } else {
            ExtentTestManager.getTest().info("Step completed");
        }
    }

    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            ExtentTestManager.getTest().fail("Scenario failed");
        } else {
            ExtentTestManager.getTest().pass("Scenario passed");
        }

        // ensure flush so report file is written
        ExtentManager.getInstance().flush();
        ExtentTestManager.removeTest();
    }
}
