Feature: Sauce demo Website


  Scenario: Successful login with valid credentials
    Given I am on the Sauce demo login page
    When I have entered a valid username and password
    Then I click on the login button


  Scenario Outline: Unsuccessful login with invalid or empty credentials
    Given I am on the Sauce demo login page
    Given I have entered invalid "<username>" and "<password>"
    When I click on the login button
    Then I should see an error message indicating "<error_message>"

    Examples:
      | username      | password        | error_message                                                             |
      | standard_user | secret_sauce)   | Epic sadface: Username and password do not match any user in this service |
      | standard_user | invalidPassword | Epic sadface: Username and password do not match any user in this service |

  Scenario: Add the highest price item to the cart

    Given I am on the Sauce demo login page
    When I have entered a valid username and password
    Then I click on the login button
    When I manually identify the highest price item
    And I add the highest price item to the cart
    Then The highest price item should be in the cart
