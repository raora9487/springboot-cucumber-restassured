package config;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = TestApplication.class)
public class CucumberSpringConfiguration {

    static {
        // If no profile is set externally, default to "dev"
        if (System.getProperty("spring.profiles.active") == null) {
            System.setProperty("spring.profiles.active", "dev");
        }
    }
}
