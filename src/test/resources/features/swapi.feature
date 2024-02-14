@UserPersonalInfo
Feature: SwAPI Verification


  Scenario Outline: Verification of Users

    When I create request for "SWAPI_SERVICE" service with "<TestData>"
    Then I do get request to "SWAPI_SERVICE" service
    And  Validate "User" personal details


    Examples:
      | TestData      |
      | userInfo |








