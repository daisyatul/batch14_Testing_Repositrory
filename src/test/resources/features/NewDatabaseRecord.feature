Feature: Temp

  @datatable
  Scenario: Example Scn
    Given I want to do something
    When I have a arguments to send as "Romali"
    When I have a list of item to send
    |akash|
    |chetana|
    |shradhha|
    |romali  |
    Then something should happen
    When I have students and their marks
      | akash        | 34    |
      | shraddha     | 45    |
      | chetna       | 56    |
      | romali       | 67    |
    Then something should happen

  @Example
  Scenario: I want to search for the product
    Given I am on the search page
    When I search for a product as "computer"
    Then result should be displayed related to "computer"


  @Example
  Scenario Outline: I want to search for the product
    Given I am on the search page
    When I search for a product as "<Product>"
    Then result should be displayed related to "<Product>"

    Examples:
    |Product|
    |computer|
    |mobile  |
    |keyboard|
    |mouse   |
    |earphone|
    |bluetooth|