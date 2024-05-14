package pages;

import base.BasePage;
import enums.WaitStrategy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import utilities.ScrollFactory;
import utilities.WaitFactory;

public class CartPage extends BasePage {
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"\uDB82\uDE7A\"]")
    private MobileElement Bin;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='YOUR CART']")
    private MobileElement YourCart;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='CHECKOUT']")
    private MobileElement CheckoutBtn;
    public void clickBin() {
        WaitFactory.waitForElement(WaitStrategy.VISIBLE, YourCart);
//        ScrollFactory.scroll(ScrollFactory.ScrollDirection.RIGHT, 0.6, 1);
        ScrollFactory.swipe("LEFT", 1, 1000);
        click(Bin);
    }
    public void clickCheckoutBtn() {
        click(CheckoutBtn);
    }
}
