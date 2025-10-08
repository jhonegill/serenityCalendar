@Calendar
Feature: Select dates in jQuery Calendar

  @TestCurrentMonth
  Scenario: Select day 15 of the current month
    Given the user opens the Calendar page
    When the user selects day 15 of the current month
    Then the selected date should appear in the input field
@TestNextMonth
  Scenario: Select day 10 of the next month
    Given the user opens the Calendar page
    When the user selects day 10 of the next month
    Then the selected date should appear in the input field

  @TestFail
  Scenario: Validate that manual input is not allowed
    Given the user opens the Calendar page
    When the user tries to type a date manually
    Then the field should not be editable manually

  @@TestDynamicMonth
  Scenario: Select a specific date dynamically
    Given the user opens the Calendar page
    When the user selects the date "19/02/2025"
    Then the selected date should appear in the input field