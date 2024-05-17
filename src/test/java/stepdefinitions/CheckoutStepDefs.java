package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;
import pages.CheckoutPage;
import pages.ProductsPage;

public class CheckoutStepDefs {
    ProductsPage productsPage = new ProductsPage();
    CartPage cartPage = new CartPage();
    CheckoutPage checkoutPage = new CheckoutPage();
    @When("^User scrolls down to the end of product page$")
    public void scrolldown() {
        productsPage.scrollToBottom();
    }

    @And("User adds two products into cart")
    public void userAddsTwoProductsIntoCart() {
        productsPage.clickToAddItem();
        productsPage.clickToAddAnotherItem();
    }

    @And("clicks Cart icon")
    public void clicksCartIcon() {
        productsPage.clickCart();
    }

    @And("deletes one of the items in cart")
    public void deleteOneItem() {
        cartPage.clickBin();
    }

    @And("clicks button CHECKOUT")
    public void clicksButtonCHECKOUT() {
        cartPage.clickCheckoutBtn();
    }

    @And("enters {string}, {string} and {string}")
    public void entersAnd(String firstname, String lastname, String zipcode) {
        checkoutPage.enterFirstName(firstname);
        checkoutPage.enterLastName(lastname);
        checkoutPage.enterZipCode(zipcode);
    }

    @And("clicks continue button")
    public void clicksContinueButton() {
        checkoutPage.clickContinue();
    }

    @And("User clicks on finish button")
    public void userClicksOnFinishButton() {
        checkoutPage.clickFinish();
    }

    @Then("successful {string} is displayed")
    public void verifyOrder(String message) {
        checkoutPage.verifyOrderComplete(message);
        checkoutPage.takeScreenshot();
    }
}
