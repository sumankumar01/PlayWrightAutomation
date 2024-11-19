Feature: Google search

  @smoke
  Scenario Outline: I want to login orange hrm for negative with invalid credential
    Given I am on the orangehrm sites
    When I enter "<username>" as a userName to login
    When I enter "<password>" as a password to login
    Then I verify login error msg


    Examples:
      | username     | password       |
      | suman        | kumar       |
