Feature: A basic Cucumber test without Selenium

  @simple
  Scenario: Withdraw £50 from an account with sufficient funds
    Given I have a balance of "£100"
    When I withdraw "£50"
    Then I should have a balance of "£50"

  @don'tRun
  Scenario: Withdraw £100 from an account with sufficient funds
    Given I have a balance of "£500"
    When I withdraw "£100"
    Then I should have a balance of "£400"