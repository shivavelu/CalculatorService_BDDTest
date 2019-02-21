Feature: Verify Calculator Functions
  User verify simple calculator Multiplication functions

  Scenario: Verify Multiply function
    Given calculator multiply resource url
      | GET                       |
      | http://localhost:8080/Multiply |
    When user provide input for multiply "5" and "4"
    Then user verify multiply api response:
      | ResponseCode | Output |
      |          200 |      20|