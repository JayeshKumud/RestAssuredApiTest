package runner;

import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import managers.FileReaderManager;
import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;

//@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/functionalTests",
        glue= {"stepDefinitions"},
        plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
        monochrome = true, tags={"@Test"})
public class CucumberRunner extends AbstractTestNGCucumberTests {
    @AfterClass
    public static void writeExtentReport(){
        Reporter.loadXMLConfig(FileReaderManager.INSTANCE.getConfigFileReader().getReportConfigPath());
        Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
        Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
        Reporter.setSystemInfo("Machine", 	"Windows 10" + "64 Bit");
    }
}
