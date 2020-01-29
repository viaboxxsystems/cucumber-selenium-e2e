# Created by jnonnen at 13.12.19
Feature: Owner search

  Scenario Outline: Search owner with name "<name>"
    Given I navigate to Find Owner
    When I search for a owner with name "<name>"
    Then I see the owner list page
    And I expect to find <num> owners


    Examples:
      | name     | num |
      | Franklin | 1   |
      | D        | 2   |
      |          | 10  |
      | Davis    | 2   |

