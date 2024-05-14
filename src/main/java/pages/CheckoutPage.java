package pages;

import base.BasePage;
import enums.WaitStrategy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import utilities.ScreenshotFactory;
import utilities.ScrollFactory;
import utilities.WaitFactory;

public class CheckoutPage extends BasePage {
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='test-First Name']")
    private MobileElement FirstName;
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='test-Last Name']")
    private MobileElement LastName;
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='test-Zip/Postal Code']")
    private MobileElement ZipCode;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='CONTINUE']")
    private MobileElement ContinueBtn;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='test-FINISH']")
    private MobileElement FinishBtn;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='THANK YOU FOR YOU ORDER']")
    private MobileElement OrderCompleteMsg;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='CHECKOUT: OVERVIEW']")
    private MobileElement CheckoutTitle;
    @AndroidFindBy(xpath = "//android.widget.ScrollView[@content-desc='test-CHECKOUT: COMPLETE!']/" +
            "android.view.ViewGroup/android.widget.ImageView")
    private MobileElement Image;
    public void enterFirstName(String firstname) {
        type(FirstName, firstname);
    }

    public void enterLastName(String lastname) {
        type(LastName, lastname);
    }

    public void enterZipCode(String zipcode) {
        type(ZipCode, zipcode);
    }

    public void clickContinue() {
        click(ContinueBtn);
    }

    public void clickFinish() {
        WaitFactory.waitForElement(WaitStrategy.VISIBLE, CheckoutTitle);
//        ScrollFactory.scroll(ScrollFactory.ScrollDirection.DOWN, 0.4, 3);
        ScrollFactory.swipe("UP", 2, 1000);
        click(FinishBtn);
    }
    public void verifyOrderComplete(String message) {
        verify(OrderCompleteMsg, message);
    }
    public void takeScreenshot() {
        ScreenshotFactory.captureScreenshots("OrderComplete", 0, 380, 1080, 1380);
    }
}
