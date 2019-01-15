package runner;

import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import managers.FileReaderManager;
import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/functionalTests",
        glue= {"stepDefinitions"},
        plugin = {"pretty", "json:target/cucumber-reports/Cucumber.json"},
        monochrome = true, tags={"@Test1"})
public class RunnerPrettyPlugin1 {

}
