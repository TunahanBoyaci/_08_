Feature: Citizenship with Apache POI

  Background: Login
    Given Navigate to Campus
    And Enter username and password
    And Click on login Button
    And Navigate to Citizenship page

#  Scenario: Create a new Citizenship
#    And Create a citizenship with Apache POI

    Scenario: Delete a new Citizenship
      And Delete a citizenship with Apache POI