Feature: Verify Calculator Functions
  User verify simple calculator Subtraction functions

  Scenario: Verify Subtract function
    Given calculator subtract resource url
      | GET                            |
      | http://localhost:8080/Subtract |
    When user provide input to subatract "24" and "4"
    Then user verify subtract api response:
      | ResponseCode | Output |
      |          200 |     20 |
