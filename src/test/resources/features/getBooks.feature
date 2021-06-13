Feature: Validate Get list book feature
  I want to verify the book lists in API

  Scenario: Validate get list book response 200
    When I want go to book API
    Then I verify the status code as 200

  Scenario: Search the book 198 in the books list
    When I want go to book API
    Then I want to search 'Book 198' in list

  Scenario: Search the book 200 not in the books list
    When I want go to book API
    Then I want to search 'Book 200' not in list

  Scenario: Search the book 500 in the books list
    When I want go to book API
    Then I want to search 'Book 500' in list

  Scenario: Counting number of book is 200
    When I want go to book API
    Then I want to count total books equal 200