@SecurianAssignment
Feature: Securian Retirement Savings Verification

  Scenario Outline: Retirement calculator tests
    When I launch the application
    Then I enter "<RetiredData>" to inputBox
    Then I click on "save" button
    Then I click on "calculate" button
    And I validate "Result" is displayed

    Examples:
      | RetiredData      |
      | retiredData |






