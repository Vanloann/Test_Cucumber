package run;

import base.BaseTest;
import driver.AppDriver;
import io.cucumber.java.Scenario;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import utilities.ScreenshotFactory;

import java.net.MalformedURLException;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"stepdefinitions"},
        plugin = {"pretty", "html:target/cucumber-reports/RunCucumberTest.html",
                "json:target/cucumber-reports/RunCucumberTest.json"},
        tags = "",
        monochrome = true)
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
