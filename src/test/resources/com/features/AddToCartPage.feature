@test
Feature: Add to cart Functionality

  Background:
    Given User logged into the homepage

  Scenario: To Add two products to cart
    When user checks the add to cart button is present
    And user add two products to the cart
    Then products added sucessfully

  Scenario: To remove the one products
    When user checks the remove from cart button is present
    And user remove one of the product
    Then user removed product sucessfully
