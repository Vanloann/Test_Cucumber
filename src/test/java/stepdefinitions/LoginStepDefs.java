package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.ProductsPage;

public class LoginStepDefs {
    LoginPage loginPage = new LoginPage();
    ProductsPage productsPage = new ProductsPage();
    @When("User enter username as {string}")
    public void userEnterUsernameAs(String userName) {
        loginPage.enterUserName(userName);
    }
    @And("User enter password as {string}")
    public void userEnterPasswordAs(String password) {
        loginPage.enterPassword(password);
    }

    @And("clicks on login")
    public void clicksOnLogin() {
        loginPage.clickLoginBtn();
    }

//    @Then("login should fail with an error {string}")
//    public void loginShouldFailWithAnError(String errorMsg) {
//        loginPage.verifyError(errorMsg);
//    }

    @Then("title of product page will be displayed {string}")
    public void titleOfProductPageWillBeDisplayed(String title) {
        productsPage.verifyTitleDisplayed(title);
    }


}
