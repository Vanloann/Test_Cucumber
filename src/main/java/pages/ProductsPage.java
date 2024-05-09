package pages;

import base.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ProductsPage extends BasePage {
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='PRODUCTS']")
    private MobileElement Title;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Menu']/android.view.ViewGroup/android.widget.ImageView")
    private MobileElement SideBar;

    public void verifyTitleDisplayed(String title) {
        verify(Title, title);
    }

    public void clickSideBar() {
       click(SideBar);
    }
}
