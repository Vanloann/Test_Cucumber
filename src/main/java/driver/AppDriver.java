package driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class AppDriver {
//    private static AppDriver instance = null;
    private static AppiumDriver<MobileElement> driver;
    private AppDriver(){

    }

//    public static AppDriver getDriver(){
//        if(instance ==null){
//            instance = new AppDriver();
//        }
//        return instance;
//    }

    public static AppiumDriver<MobileElement> getCurrentDriver() {
        return driver;
    }

    public static void setDriver(AppiumDriver<MobileElement> Driver){
        driver = Driver;
        System.out.println("Driver is set");
    }
}
