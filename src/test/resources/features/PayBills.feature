Feature: PayBills Page should have features below

  Background:
    Given the user is logged in


    Scenario: Pay Bills Activity Page should have specifications below

      Given Pay Bills page should have the title "Zero - Pay Bills"
      Then After successful Pay operation, "The payment was successfully submitted." should be displayed
      Then Without entering the amount or date, "Please fill out this field." should be displayed
