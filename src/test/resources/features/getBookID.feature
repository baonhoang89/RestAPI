Feature: Validate get book feature
  I want to verify the specific book in API

  Scenario Outline: Validate get specific book response 200
    When I want go to book API
    Then I verify book ID "<bookID>" the status OK
    Examples:
      | bookID |
      | 99     |
      | 100    |
      | 101    |
      | 102    |

  Scenario Outline: Validate schema json of book
    When I want go to book API
    Then I verify schema of book ID "<bookID>"
    Examples:
      | bookID |
      | 99     |
      | 100    |
      | 101    |
      | 102    |