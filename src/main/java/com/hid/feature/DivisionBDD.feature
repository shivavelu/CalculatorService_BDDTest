Feature: Verify Calculator Functions
  User verify simple calculator Division functions

  Scenario: Verify Division function
    Given calculator division resource url
      | GET                       |
      | http://localhost:8080/Divide |
    When user provide input for divide "65" and "3"
    Then user verify divide api response:
      | ResponseCode | Output |
      |          200 |      21.2|

