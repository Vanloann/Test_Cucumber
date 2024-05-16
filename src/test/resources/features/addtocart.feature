#@AddToCart
Feature: Login test

  Background: Login with valid username
    When User enter username as "standard_user"
    And User enter password as "secret_sauce"
    And clicks on login
    Then title of product page will be displayed "PRODUCTS"

  Scenario Outline: Add to cart and checkout successfully
    When User scrolls down to the end of product page
    And User adds two products into cart
    And clicks Cart icon
    And deletes one of the items in cart
    And clicks button CHECKOUT
    And enters "<firstname>", "<lastname>" and "<zipcode>"
    And clicks continue button
    And User clicks on finish button
    Then successful "<message>" is displayed
    Examples:
      | firstname | lastname | zipcode | message                 |
      | Loan      | Van      | 550000  | THANK YOU FOR YOU ORDER |
