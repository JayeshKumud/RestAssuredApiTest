package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/functionalTests",
        glue= {"stepDefinitions"},
        plugin = {"pretty", "json:target/cucumber-reports/Cucumber.json"},
        monochrome = true, tags={"@Test2"})
public class RunnerPrettyPlugin2 {

}
