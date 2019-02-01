package runner;

import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import managers.FileReaderManager;
import org.testng.annotations.AfterClass;

@CucumberOptions(
        features = "src/test/resources/functionalTests",
        glue= {"stepDefinitions"},
        plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/CucumberReports/report.html"},
        monochrome = true, tags={"@Test2"})
public class JunitRunner2 extends AbstractTestNGCucumberTests {
    @AfterClass
    public static void writeExtentReport(){
        Reporter.loadXMLConfig(FileReaderManager.INSTANCE.getConfigFileReader().getReportConfigPath());
        Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
        Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
        Reporter.setSystemInfo("Machine", 	"Windows 10" + "64 Bit");
    }
}
