@test
Feature: To Checkout the Product

  Background:
    Given user logged in Sucessfully

  Scenario: To Checkout the product
    When user clicks add to cart button
    And user clicks the cart icon
    Then user finds the product added
    And user clicks the checkout button
    And user enters the name as "Naveen"
    And user enters te lastname as "Raj"
    And user enters the zipcode as "624601"
    And user clicks the finish button
    Then user ordered the product sucessfully
