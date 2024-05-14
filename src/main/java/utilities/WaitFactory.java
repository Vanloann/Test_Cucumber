package utilities;
import driver.AppDriver;
import enums.WaitStrategy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitFactory {
    public static WebDriverWait wait = new WebDriverWait(AppDriver.getCurrentDriver(), 5L);

    public static void waitForElement(WaitStrategy waitStrategy, MobileElement element) {
        switch (waitStrategy) {
            case CLICKABLE:
                wait.until(ExpectedConditions.elementToBeClickable(element));
                break;
            case VISIBLE:
                wait.until(ExpectedConditions.visibilityOf(element));
                break;
        }
    }
}
