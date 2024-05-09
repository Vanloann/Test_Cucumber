package pages;

import base.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
//import org.testng.Assert;

public class LoginPage extends BasePage {
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='test-Username']")
    private MobileElement UserName;
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='test-Password']")
    private MobileElement Password;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='test-LOGIN']")
    private MobileElement LoginBtn;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Username and password do not match any user " +
            "in this service.']")
    private MobileElement ErrorMsg;

    public void login(String username, String password) {
        type(UserName, username);
        type(Password, password);
        click(LoginBtn);
    }
    public void enterUserName(String username) {
        type(UserName, username);
    }
    public void enterPassword(String password) {
        type(Password, password);
    }
    public void clickLoginBtn() {
        click(LoginBtn);
    }
    public void verifyLoginFail() {
        verify(ErrorMsg, "Username and password do not match any user in this service.");
    }
    public void verifyError(String message) {
        verify(ErrorMsg, message);
    }


}
