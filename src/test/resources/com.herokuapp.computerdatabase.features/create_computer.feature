Feature: Create a computer
  As a user of the computer database I want to create a computer

  @create_computer
  Scenario: Create a computer
    Given I want to add a new computer to the database
    When I add a new computer to the database
    Then the computer is added to the database