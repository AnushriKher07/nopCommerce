Feature: Login

  Scenario: Successful Login
    Given I am on the login page
    When I enter valid login details
    And I submit the login form
    Then I should be logged in successfully