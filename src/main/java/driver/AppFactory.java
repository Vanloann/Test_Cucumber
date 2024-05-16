package driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AppFactory {
    private static AppiumDriver<MobileElement> driver;

    public static void android_launchApp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        // LOCAL
//        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
//        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android4Test");
//        capabilities.setCapability(MobileCapabilityType.APP, "D:\\AUT_LoanTTV\\Test_Cucumber\\cucumber_ci_cd_test" +
//                "\\src\\app\\Android.SauceLabs.Mobile.Sample.app.2.7.1 (1).apk");
//        capabilities.setCapability("appPackage", "com.swaglabsmobileapp");
//        capabilities.setCapability("appActivity", "com.swaglabsmobileapp.SplashActivity");
//        driver = new AppiumDriver<>(new URL("http://localhost:4723/wd/hub"), capabilities);

        // BROWSERSTACK
        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("browserstack.user", "vanloan_1qytur");
        capabilities.setCapability("browserstack.key", "yuD4TEGXhdHMwEWREfNb");
        capabilities.setCapability("app", "bs://6a53b0a39a8dbb61883552cb0d4c39ec9efbe2bc");
        capabilities.setCapability("deviceName", "Google Pixel 3a");
        capabilities.setCapability("platformVersion", "9.0");
        capabilities.setCapability("browserstackLocal", "false");
        capabilities.setCapability("buildName", "browserstack-build-1");
        capabilities.setCapability("projectName", "BrowserStack Sample");
        capabilities.setCapability("browserstack.idleTimeout", "300");
        driver = new AppiumDriver<MobileElement>(new URL("http://hub-cloud.browserstack.com/wd/hub"), capabilities);
        AppDriver.setDriver(driver);
        System.out.println("AndroidDriver is set");
    }
}
