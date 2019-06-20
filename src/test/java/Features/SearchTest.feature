#This is the feature file, it is the controller of the specific tests
Feature: Search Test

  Scenario: Open the homepage and search for something
    Given the user is on the homepage
    When they search for "Mobile Phones"
    Then the results page' title should be "Amazon.co.uk: Mobile Phones"

  Scenario: Open the homepage and search for something
    Given the user is on the homepage
    When they search for "Laptops"
    Then the results page' title should be "Amazon.co.uk: Laptops"