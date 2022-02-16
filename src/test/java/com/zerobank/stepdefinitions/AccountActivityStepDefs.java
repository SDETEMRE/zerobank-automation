package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class AccountActivityStepDefs {

    @Given("the user is logged in")
    public void the_user_is_logged_in() {

       String username = ConfigurationReader.get("username");
       String password = ConfigurationReader.get("password");
       new LoginPage().login(username,password);

    }

    @When("the user clicks on Savings link on the Account Summary page")
    public void the_user_clicks_on_Savings_link_on_the_Account_Summary_page() {
        new AccountSummaryPage().savingsButton.click();

    }

    @Then("the Account Activity page should be displayed")
    public void the_Account_Activity_page_should_be_displayed() {
        String expected = "account-activity";
        String actual = Driver.get().getCurrentUrl();
        Assert.assertTrue(expected,actual.contains("account-activity"));
    }

    @Then("Account drop down should have Savings selected")
    public void account_drop_down_should_have_Savings_selected() {
        AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
        String expectedTitle = "Savings";
        String actualTitle = accountSummaryPage.dropDownAccount(0);
        Assert.assertEquals(expectedTitle,actualTitle);
    }

    @When("the user clicks on Brokerage link on the Account Summary page")
    public void the_user_clicks_on_Brokerage_link_on_the_Account_Summary_page() {
        new AccountSummaryPage().brokerageButton.click();

    }

    @Then("Account drop down should have Brokerage selected")
    public void account_drop_down_should_have_Brokerage_selected() {
        AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
        Assert.assertTrue(accountSummaryPage.dropDownAccount(5).equals("Brokerage"));
    }

    @When("the user clicks on Checking link on the Account Summary page")
    public void the_user_clicks_on_Checking_link_on_the_Account_Summary_page() {
       new AccountSummaryPage().checkingLink.click();
    }

    @Then("Account drop down should have Checking selected")
    public void account_drop_down_should_have_Checking_selected() {
        AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
        Assert.assertTrue(accountSummaryPage.dropDownAccount(1).equals("Checking"));
    }

    @When("the user clicks on Credit card link on the Account Summary page")
    public void the_user_clicks_on_Credit_card_link_on_the_Account_Summary_page() {
       new AccountSummaryPage().creditCard.click();
    }

    @Then("Account drop down should have Credit Card selected")
    public void account_drop_down_should_have_Credit_Card_selected() {
        AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
        Assert.assertTrue(accountSummaryPage.dropDownAccount(4).equals("Credit Card"));
    }

    @When("the user clicks on Loan link on the Account Summary page")
    public void the_user_clicks_on_Loan_link_on_the_Account_Summary_page() {
       new AccountSummaryPage().loan.click();
    }

    @Then("Account drop down should have Loan selected")
    public void account_drop_down_should_have_Loan_selected() {
        AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
        Assert.assertTrue(accountSummaryPage.dropDownAccount(3).equals("Loan"));
    }


}
