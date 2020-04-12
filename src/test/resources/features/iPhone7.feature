Feature: Test Example

  Scenario: Search for iPhone 7
    When I click "Search box"
    And  I search for "iPhone 7"
    Then I see the following fields:
      | Save Button   |
      | Sort Button   |
      | Filter Button |

  Scenario: Buy iPhone 7
    When I click "Search box"
    And  I search for "iPhone 7"
    And  I click "First Search Result"
    And  I "select options" with following data:
      | Storage Capacity Selector | Color Selector |
      | 128GB                     | Black          |
    And  I click "BUY IT NOW"
    Then I see the following fields:
      | Sign in               |
      | USE EMAIL OR USERNAME |
      | SIGN IN WITH GOOGLE   |
      | SIGN IN WITH FACEBOOK |
      | CREATE AN ACCOUNT     |

  Scenario: Add iPhone to cart
    When I click "Search box"
    And  I search for "iPhone 7"
    And  I click "First Search Result"
    And  I scroll to "Add to cart"
    And  I click "Add to cart"
    And  I "select options" with following data:
      | Storage Capacity Selector | Color Selector |
      | 128GB                     | Black          |
    And  I click "Add to cart"
    Then I see the following fields:
      | Sign in               |
      | USE EMAIL OR USERNAME |
      | SIGN IN WITH GOOGLE   |
      | SIGN IN WITH FACEBOOK |
      | CREATE AN ACCOUNT     |
