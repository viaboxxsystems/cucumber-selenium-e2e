# Created by jnonnen at 13.12.19
Feature: Owner search
   #This is how background can be used to eliminate duplicate steps
  Background:
  Given I navigate to Find Owner

  Scenario: Owner not found
    When I search for a owner with name "Blub"
    Then I expect to find no owner

  Scenario: One Owner found
    When I search for a owner with name "F"
    Then I expect to find 1 owner
    And I see the owner list page

  Scenario: All Owner found
    When I search for a owner with name ""
    Then I expect to find 10 owners

  Scenario: All Owner found
    When I search for a owner with name ""
    Then I expect to find the owners
      | name |  address | city |
      | George Franklin | 110 W. Liberty St. | Madison |
      | Betty Davis | 638 Cardinal Ave. | Sun Prairie |