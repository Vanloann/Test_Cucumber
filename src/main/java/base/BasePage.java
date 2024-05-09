package base;

import driver.AppDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {
    public WebDriverWait wait;

    public BasePage() {
        PageFactory.initElements(new AppiumFieldDecorator(AppDriver.getCurrentDriver()), this);
        wait = new WebDriverWait(AppDriver.getCurrentDriver(), 2L);
    }
    protected void waitForElement(MobileElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void click(MobileElement element){
        waitForElement(element);
        element.click();
    }

    protected void type(MobileElement element, String text){
        waitForElement(element);
        element.sendKeys(text);
    }

    protected String getText(MobileElement element) {
        return element.getText();
    }

    protected void verify(MobileElement element, String text){
        waitForElement(element);
        System.out.println(getText(element));
        Assert.assertEquals(element.getText(), text);
    }
}
