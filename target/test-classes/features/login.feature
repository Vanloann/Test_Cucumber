Feature: Login test

#  Scenario Outline: Login with invalid username
#    When User enter username as "<username>"
#    And User enter password as "<password>"
#    And clicks on login
#    Then login should fail with an error "<error_message>"
#    Examples:
#      | username      | password | error_message                                                |
#      | standard_user | 123      | Username and password do not match any user in this service. |

  Background: : Login with valid username
    When User enter username as "standard_user"
    And User enter password as "secret_sauce"
    And clicks on login
    Then title of product page will be displayed "PRODUCTS"

#    Examples:
#      | username      | password     | title    |
#      | standard_user | secret_sauce | PRODUCTS |

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