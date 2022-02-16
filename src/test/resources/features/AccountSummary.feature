Feature:


  Scenario: Account summary page account types
    Given the user is logged in
    Given Account summary page displayed
    Then Account Types should be seen

      | Cash Accounts       |
      | Investment Accounts |
      | Credit Accounts     |
      | Loan Accounts       |

    Then Credit Accounts table must have seen

      | Account     |
      | Credit Card |
      | Balance     |