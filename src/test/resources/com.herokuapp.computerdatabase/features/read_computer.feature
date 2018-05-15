@read_computer
Feature: Read a computer
  As a user of the computer database I want to search for a computer

  Scenario: Search for a computer
    Given I want to search for a computer in the database
    When I search for computer "ASCI White" in the database
    Then then the computer details are displayed

  Scenario: Search for a computer not in the database
    Given I want to check that a computer is not in the database
    When I search for the computer "???we%&123" in the database
    Then no computers are found