# Created by jnonnen at 13.12.19
Feature: Owner search

  Scenario: Owner not found
    Given I navigate to Find Owner
    When I search for a owner with name "Blub"
    Then I expect to find no owner

  Scenario: One Owner found
    Given I navigate to Find Owner
    When I search for a owner with name "F"
    Then I expect to find 1 owner

  Scenario: All Owner found
    Given I navigate to Find Owner
    When I search for a owner with name ""
    Then I expect to find 10 owners