Feature: Registration

  Scenario: Successful Registration
    Given I am on the registration page
    When I select the gender as "Male"
    And I enter the first name "John"
    And I enter the last name "Doe"
    And I select the date of birth as "10/June/1990"
    And I enter the email "john.doe@example.com"
    And I enter the company name "Example Corp"
    And I enter the password "Password123"
    And I enter the confirmation password "Password123"
    And I submit the registration form
    Then I should see a registration success message
    
    Examples:
    | FirstName | LastName | Email                 | Password   | ConfirmPassword | Gender | Dob         | Company        |
    | John      | Doe      | john.doe@example.com  | Password123 | Password123     | Male   | 01-01-1990  | ExampleCompany |
    | Jane      | Smith    | jane.smith@example.com| Password123 | Password123     | Female | 12-12-1985  | ExampleCompany |