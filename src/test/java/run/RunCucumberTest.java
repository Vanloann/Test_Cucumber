package run;

import base.BaseTest;
import driver.AppDriver;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.net.MalformedURLException;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {""}
)
public class RunCucumberTest extends BaseTest {
    @BeforeClass
    public static void beforeClass() throws MalformedURLException {
        getDriver();
    }
    @AfterClass
    public static void tearDown() throws Exception {
        if (AppDriver.getCurrentDriver() != null) {
            AppDriver.getCurrentDriver().quit();
        }
        System.out.println("App is closed.");
    }
}
