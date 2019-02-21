Feature: Verify Calculator Functions
  User verify simple calculator Addition functions

  Scenario: Verify Add function
    Given calculator add resource url
      | GET                       |
      | http://localhost:8080/Add |
    When user provide input "5" and "4"
    Then user verify api response:
      | ResponseCode | Output |
      |          200 |      9 |
