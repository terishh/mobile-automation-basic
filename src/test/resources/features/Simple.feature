Feature: Test Example

  Scenario: Search for iPhone 7
    When I click "Search box"
    And  I search for "iPhone 7"
    Then I see the following fields:
      | Save Button   |
      | Sort Button   |
      | Filter Button |
