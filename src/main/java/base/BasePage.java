package base;

import driver.AppDriver;
import enums.WaitStrategy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;
import utilities.WaitFactory;


public class BasePage {
    public BasePage() {
        PageFactory.initElements(new AppiumFieldDecorator(AppDriver.getCurrentDriver()), this);
    }

    protected void clear(MobileElement element) {
        element.clear();
    }

    protected void click(MobileElement element){
        WaitFactory.waitForElement(WaitStrategy.CLICKABLE, element);
        element.click();
    }

    protected void type(MobileElement element, String text){
        WaitFactory.waitForElement(WaitStrategy.VISIBLE, element);
        clear(element);
        element.sendKeys(text);
    }

    protected String getText(MobileElement element) {
        return element.getText();
    }

    protected void verify(MobileElement element, String text){
        WaitFactory.waitForElement(WaitStrategy.VISIBLE, element);
        System.out.println(getText(element));
        Assert.assertEquals(element.getText(), text);
    }
}
