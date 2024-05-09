Feature: Login test

  Scenario Outline: Login with invalid username
    When User enter username as "<username>"
    And User enter password as "<password>"
    And clicks on login
    Then login should fail with an error "<error_message>"
    Examples:
      | username      | password | error_message                                                |
      | standard_user | 123      | Username and password do not match any user in this service. |

  Scenario Outline: Login with valid username
    When User enter username as "<username>"
    And User enter password as "<password>"
    And clicks on login
    Then title of product page will be displayed "<title>"
    Examples:
      | username      | password     | title                                                |
      | standard_user | secret_sauce | PRODUCTS |