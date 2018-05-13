@delete_computer
Feature: Delete a computer
  As a user of the computer database I want to delete a computer

  Scenario: Create a computer then delete the computer
    Given I want to delete a computer from the database
    When I delete the "TestPC" computer
    Then the computer is deleted