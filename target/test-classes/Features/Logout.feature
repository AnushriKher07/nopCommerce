Feature: Logout

  Scenario: Successful Logout
    Given I am logged in
    When I click on the logout button
    Then I should be logged out successfully