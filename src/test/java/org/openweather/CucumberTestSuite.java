package org.openweather;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

/**
 * @author Smita Sahu
 * Starter class to run cucumber test suite with Serenity
 */
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "classpath:features",
        glue={"org.openweather.cucumber.steps"},
        plugin = {"pretty","html:target/reports/reports.html"}
)
public class CucumberTestSuite {
}
