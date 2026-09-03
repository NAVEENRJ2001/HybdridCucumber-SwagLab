@test
Feature: To Sort the Product

Background:
Given user logged into the homepage 
And user clicks the filter button 

  Scenario: Filter -> Name (Z to A)
    When user select the Name (Z to A) filter
    Then all product will change into descending order

  Scenario: Filter -> Price (Low to High)
    When user select the Price (Low to High) filter
    Then all product's price will change into low to high

  Scenario: Filter -> Price (High to Low)
    When user select the Price (High to Low) filter
    Then all product's price will change into high to low

  Scenario: Filter -> Name (A to Z)
    When user select the Name (A to Z) filter
    Then all product will change into Ascending order


