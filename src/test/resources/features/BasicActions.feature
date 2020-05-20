Feature: Basic Actions

  Scenario: Search for iPhone 7
    When I click "Search box"
    And  I search for "iPhone 7"
    Then I see the following fields:
      | Save Button   |
      | Sort Button   |
      | Filter Button |

  @WIP
  Scenario: Buy iPhone 7
    When I click "Search box"
    And  I search for "Apple iPhone 7 32GB 128GB 256GB UNLOCKED SMARTPHONE GSM ALL COLORS"
    And  I click "First Search Result"
    And  I "select options" with following data:
      | Storage Capacity Selector | Color Selector |
      | 128GB                     | Gold           |
    And  I click "BUY IT NOW"
    Then I see the following fields:
      | Sign in               |
      | USE EMAIL OR USERNAME |
      | SIGN IN WITH GOOGLE   |
      | SIGN IN WITH FACEBOOK |
      | CREATE AN ACCOUNT     |
  
  @WIP
  Scenario: Add iPhone to cart
    When I click "Search box"
    And  I search for "Apple iPhone 7 32GB 128GB 256GB UNLOCKED SMARTPHONE GSM ALL COLORS"
    And  I click "First Search Result"
    And  I scroll to "Add to cart"
    And  I click "Add to cart"
    And  I "select options" with following data:
      | Storage Capacity Selector | Color Selector |
      | 128GB                     | Gold           |
    And  I click "Add to cart"
    Then I see the following fields:
      | Sign in               |
      | USE EMAIL OR USERNAME |
      | SIGN IN WITH GOOGLE   |
      | SIGN IN WITH FACEBOOK |
      | CREATE AN ACCOUNT     |
  
  @WIP @NEW_FEATURE
  Scenario: Check categories
    When I click "Stack button"
    And  I click "Categories"
    Then I see the following fields:
      | Antiques |
      | Art      |
      | Baby     |
      | Books    |

  @WIP @NEW_FEATURE
  Scenario: Check categories - Antiques
    When I click "Stack button"
    And  I click "Categories"
    And  I click "Antiques"
    Then I see the following fields:
      | Antiquities            |
      | Architectural & Garden |
      | Asian Antiques         |
      | Decorative Arts        |

  @WIP @NEW_FEATURE
  Scenario: Check categories - Antiques
    When I click "Stack button"
    And  I click "Categories"
    And  I click "Antiques"
    And  I click "Ethnographic"
    Then I see the following fields:
      | African                   |
      | Latin American            |
      | Native American           |
      | Pacific Islands & Oceania |
