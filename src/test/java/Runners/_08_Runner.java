package Runners;

import Utilities.ParameterDriver;
import com.aventstack.extentreports.service.ExtentService;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;

@CucumberOptions(
        features = "src/test/java/FutureFiles/_08_CitizenshipWithApachePOI.feature",
        glue = "StepDefinitions",
        plugin = {"pretty",
                "html:target/site/cucmber-pretty",
                "json:target/cucumber/cucumber.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        }
)

public class _08_Runner extends AbstractTestNGCucumberTests {

    //    @BeforeClass
    @Parameters(value = "browser")
    public void beforeClass(String browserName) {
        ParameterDriver.setThreadDriverName(browserName);
    }

    @AfterTest
    public void writeOnExtentReport() {
        ExtentService.getInstance().setSystemInfo("Windows User Name", System.getProperty("user.name"));
        ExtentService.getInstance().setSystemInfo("Time Zone", System.getProperty("user.timezone"));
        ExtentService.getInstance().setSystemInfo("Tester Name", "Tunahan Boyaci");
        ExtentService.getInstance().setSystemInfo("Application Name", "Y3C Projects");
        ExtentService.getInstance().setSystemInfo("Operating System", System.getProperty("os.name"));
        ExtentService.getInstance().setSystemInfo("Department", "SDET");
    }
}
