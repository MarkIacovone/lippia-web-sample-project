Feature: Sauce Demo Web Tests

  Background:
    Given the user is on the SauceDemo login page

  @Smoke
  Scenario: Successful Login
    And the user enters username "standard_user"
    And the user enters password "secret_sauce"
    And the user clicks Login
    Then the Products page should be displayed

  @Smoke
  Scenario: Login With Error (Locked Out User)
    And the user enters username "locked_out_user"
    And the user enters password "secret_sauce"
    And the user clicks Login
    Then an error message "Epic sadface: Sorry, this user has been locked out." should be displayed

  @Smoke
  Scenario: Add And Remove Backpack From Cart
    And the user enters username "standard_user"
    And the user enters password "secret_sauce"
    And the user clicks Login
    When the user adds the backpack product to the cart
    Then the cart counter should show "1"
    When the user removes the backpack from the cart
    Then the cart counter should be empty