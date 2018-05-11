Feature: Create a computer
  As a user of the computer database I want to create a computer


  Scenario: Create a computer
    Given I want to add a new computer to the database
#    When I add a new computer to the database
    Then the computer is added to the database

  Scenario: Create a computer 2
    Given I want to add a new computer to the database
    When I add a new computer to the database
    Then then I am alerted that a computer name is required

  @create_computer
  Scenario: Search for a computer
    Given I want to add a new computer to the database
    When I search for a computer in the database
    Then then the computer details are displayed