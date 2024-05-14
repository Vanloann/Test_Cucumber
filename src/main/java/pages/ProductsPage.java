package pages;

import base.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import utilities.ScreenshotFactory;
import utilities.ScrollFactory;

public class ProductsPage extends BasePage {
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='PRODUCTS']")
    private MobileElement Title;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Menu']/android.view.ViewGroup/android.widget.ImageView")
    private MobileElement SideBar;
    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc='test-ADD TO CART'])[1]")
    private MobileElement AddAnItem;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='test-ADD TO CART']")
    private MobileElement AddAnotherItem;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Cart']/android.view.ViewGroup/android.widget.ImageView")
    private MobileElement Cart;

    public void verifyTitleDisplayed(String title) {
        verify(Title, title);
    }
    public void clickSideBar() {
        click(SideBar);
    }
    public void scrollToBottom() {
//        ScrollFactory.scroll(ScrollFactory.ScrollDirection.DOWN, 0.5, 2);
        ScrollFactory.swipe("UP", 2, 1000);
    }
    public void clickToAddItem() {
        click(AddAnItem);
    }
    public void clickToAddAnotherItem() {
        click(AddAnotherItem);
    }
    public void clickCart() {
        click(Cart);
    }

}
