

Feature: Navigating to specific accounts in Accounts Activity

  Background: Login credentials
    Given the user is logged in
    When the user clicks on Savings link on the Account Summary page

  Scenario: Savings account redirect
    Then the Account Activity page should be displayed
    And Account drop down should have Savings selected

  Scenario: Brokerage account redirect
    Then the Account Activity page should be displayed
    And Account drop down should have Brokerage selected

  Scenario: Checking account redirect
    Then the Account Activity page should be displayed
    And Account drop down should have Checking selected

  Scenario: Credit Card account redirect
    Then the Account Activity page should be displayed
    And Account drop down should have Credit Card selected

  Scenario: Loan account redirect
    Then the Account Activity page should be displayed
    And Account drop down should have Loan selected