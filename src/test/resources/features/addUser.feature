Feature:  Add User to orange hrm application


  Background: User is Logged In
    Given I am on the orangehrm sites
    When I enter "admin" as a userName to login
    When I enter "admin123" as a password to login
    Then I verify home page

  @smoke
  Scenario: I want to login orange hrm
    Given the user tries to log in with the following accounts:
      | username    | password   |
      | john_doe    | password1  |
      | jane_smith  | password2  |
    When each user attempts to log in
    Then each user should access the system successfully