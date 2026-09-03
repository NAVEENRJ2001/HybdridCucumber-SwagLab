@test
Feature: Login Page Feature

  Background: Login page title
    Given user is in login Page
    Then user gets the title of the Page

  Scenario: Login with valid credentials
    When user enters the username as "standard_user"
    And user enters the password as "secret_sauce"
    And user clicks the Login Button
    Then user gets the title of the home page

  Scenario: Login with invalid Credentials
    When user enters the empty username as ""
    And user enters the empty password as ""
    And user clicks the Login Btn
    Then user gets the error message

  Scenario: Login with invalid credential
    When user enters the invalid username as "standarduser"
    And user enters the valid password as "secret_sauce"
    And user clicks the login option
    Then user gets error message on username

  Scenario: Login with invalid credential
    When user enters the valid username as "standard_user"
    And user enters the invalid password as "secret"
    And user clicks on login button
    Then user gets error message on password
