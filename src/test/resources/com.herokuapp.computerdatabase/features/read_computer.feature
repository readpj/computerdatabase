@read_computer
Feature: Read a computer
  As a user of the computer database I want to search for a computer

  Scenario: Search for a computer
    Given I want to search for a computer in the database
    When I search for a computer in the database
    Then then the computer details are displayed