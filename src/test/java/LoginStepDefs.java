import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.ProductsPage;

public class LoginStepDefs {
    @When("User enter username as {string}")
    public void userEnterUsernameAs(String userName) {
        new LoginPage().enterUserName(userName);
    }

    @And("User enter password as {string}")
    public void userEnterPasswordAs(String password) {
        new LoginPage().enterPassword(password);
    }

    @And("clicks on login")
    public void clicksOnLogin() {
        new LoginPage().clickLoginBtn();
    }

    @Then("login should fail with an error {string}")
    public void loginShouldFailWithAnError(String errorMsg) {
        new LoginPage().verifyError(errorMsg);
    }

    @Then("title of product page will be displayed {string}")
    public void titleOfProductPageWillBeDisplayed(String title) {
        new ProductsPage().verifyTitleDisplayed(title);
    }
}
