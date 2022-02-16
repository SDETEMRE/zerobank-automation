Feature:

Background:
  @log
  Scenario: login with valid credentials
    Given the user is logged in
    Then Account summary page displayed

  @log
  Scenario Outline: login with invalid credentials <user>
    Given the user logged in "<username>" and "<password>"
    Then the user should see the message "Login and/or password are wrong."


    Examples:
      | username | password |
      | invalid  | invalid  |
      | invalid  | password |
      | username | invalid  |
      | username |          |
      |          | password |
      |          |          |
