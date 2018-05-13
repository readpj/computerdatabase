@create_computer
Feature: Create a computer
  As a user of the computer database I want to create a computer

  Scenario: Create a computer
    Given I want to add a new computer to the database
    When I add a "TestPC" computer with introduced date "2001-01-02" and discontinued date "2017-12-31" to the database
    Then the computer is added to the database
    And I can search for the new computer

  Scenario: Create a computer with no name and invalid dates
    Given I want to add a new computer to the database
    When I add a "" computer with introduced date "xyz" and discontinued date "123" to the database
    Then I am alerted that a computer name is required and the dates are invalid