package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features", // path to your feature files
        glue = {"steps", "config", "hooks"},                         // package with your step definitions
        plugin = {
                "pretty",
                "html:target/cucumber-reports.html",
                "json:target/cucumber-reports/cucumber.json"
        },
        tags = "@crud"                             // optional, only run @crud scenarios
)
public class TestRunner {
}
