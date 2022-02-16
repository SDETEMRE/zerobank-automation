Feature: Account Activity Page should have these specifications


  Background: Login credentials
    Given the user is logged in



  Scenario: Account Activity page should have the title Zero – Account activity
    Given Account Activity page should have the title "Zero - Account Activity"
    And Account drop down default option should be "Savings"
    And Account drop down should have the following options:
      | Savings     |
      | Checking    |
      | Savings     |
      | Loan        |
      | Credit Card |
      | Brokerage   |

    Then Transactions table should have column names
      | Date        |
      | Description |
      | Deposit     |
      | Withdrawal  |