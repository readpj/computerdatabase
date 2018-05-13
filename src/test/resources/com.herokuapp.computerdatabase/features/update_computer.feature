@update_computer
Feature: Update a computer
  As a user of the computer database I want to update a computer

  Scenario: Update a computer
    Given I want to update a new computer in the database
    When I update the "TestPC" computer with name "TestComputer" introduced date "1999-01-02" discontinued date "2005-11-30" and company "Amiga Corporation"
    Then the computer is updated
    And I can search for the updated computer