package base;

import driver.AppDriver;
import driver.AppFactory;
import org.junit.AfterClass;

import java.net.MalformedURLException;

public class BaseTest {
    public static void getDriver(){
      launchApp();
    }

    public static void launchApp() {
        try {
            AppFactory.android_launchApp();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Launch app successfully!");
    }


    @AfterClass
    public void tearDown() throws Exception {
        if (AppDriver.getCurrentDriver() != null) {
            AppDriver.getCurrentDriver().quit();
        }
    }
}
