package com.zerobank.stepdefinitions;

import com.zerobank.pages.*;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

import java.util.Date;
import java.util.List;

public class FindTransactionsStepDefs {

    FindTransactionsPage findTransactionsPage = new FindTransactionsPage();

    @Given("the user accesses the Find Transactions tab")
    public void the_user_accesses_the_Find_Transactions_tab() {
        new DashboardPage().navigateTo("Account Activity");
        new AccountActivityPage().findTransactions.click();
    }

    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String fromDate, String toDate) {
        findTransactionsPage.fromDate.sendKeys(fromDate);
        findTransactionsPage.toDate.sendKeys(toDate);
    }

    @When("clicks search")
    public void clicks_search() {
        new FindTransactionsPage().findButton.click();
    }


    @Then("results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String fromDate, String toDate) {

        List<String> actualDates = BrowserUtils.getElementsText(findTransactionsPage.dateColumnData);
        for (String value : actualDates) {
            Assert.assertTrue(value.compareTo(fromDate)>=0 && value.compareTo(toDate)<=0);
            System.out.println("value.compareTo(fromDate) = " + value.compareTo(fromDate));
        }

    }

    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() {

        List<String> actualDates = BrowserUtils.getElementsText(findTransactionsPage.dateColumnData);
        for(int i=0; i<actualDates.size()-1; i++){
            Assert.assertTrue(actualDates.get(i).compareTo(actualDates.get(i+1))>0);

        }
    }

    @Then("the results table should only not contain transactions dated {string}")
    public void the_results_table_should_only_not_contain_transactions_dated(String notContain) {
        List<String> resultTable = BrowserUtils.getElementsText(findTransactionsPage.dateColumnData);
        Assert.assertTrue(resultTable.contains(notContain));
        Assert.assertTrue(resultTable.size()>1);

    }
    @When("the user enters description “ONLINE”")
    public void the_user_enters_description_ONLINE() {
        findTransactionsPage.description.sendKeys("ONLINE");

    }

    @Then("results table should only show descriptions containing “ONLINE”")
    public void results_table_should_only_show_descriptions_containing_ONLINE() {
       List<String> descriptionData = BrowserUtils.getElementsText(findTransactionsPage.descriptionColumnData);
        for (String value : descriptionData) {
            Assert.assertTrue(value.contains("ONLINE"));

        }
        BrowserUtils.waitFor(2);

    }

    @When("the user enters description “OFFICE”")
    public void the_user_enters_description_OFFICE() {
        new AccountActivityPage().showTransactions.click();
        BrowserUtils.waitFor(2);
        new AccountActivityPage().findTransactions.click();
        BrowserUtils.waitFor(2);
        findTransactionsPage.description.sendKeys("OFFICE");
    }

    @Then("results table should only show descriptions containing “OFFICE”")
    public void results_table_should_only_show_descriptions_containing_OFFICE() {
        List<String> descriptionData = BrowserUtils.getElementsText(findTransactionsPage.descriptionColumnData);
        for (String value : descriptionData) {
            Assert.assertTrue(value.contains("OFFICE"));

        }
    }

    @Then("results table should not show descriptions containing “ONLINE”")
    public void results_table_should_not_show_descriptions_containing_ONLINE() {
        List<String> descriptionData = BrowserUtils.getElementsText(findTransactionsPage.descriptionColumnData);
        for (String value : descriptionData) {
            Assert.assertFalse(value.contains("ONLINE"));

        }
    }

    @When("the user enters description “online”")
    public void the_user_enters_description_online() {
        new AccountActivityPage().showTransactions.click();
        BrowserUtils.waitFor(2);
        new AccountActivityPage().findTransactions.click();
        BrowserUtils.waitFor(2);
        findTransactionsPage.description.sendKeys("online");

        }
    @Then("results table should show at least one result under Deposit")
    public void results_table_should_show_at_least_one_result_under_Deposit() {

        List<String> countDeposit = BrowserUtils.getElementsText(findTransactionsPage.depositColumnData);
        Assert.assertFalse(countDeposit.isEmpty());
    }

    @Then("results table should show at least one result under Withdrawal")
    public void results_table_should_show_at_least_one_result_under_Withdrawal() {
        List<String> countWithdrawal = BrowserUtils.getElementsText(findTransactionsPage.withdrawalColumnData);
        Assert.assertFalse(countWithdrawal.isEmpty());

    }

    @When("user selects type “Deposit”")
    public void user_selects_type_Deposit() {
       findTransactionsPage.type.click();
       Select select = new Select(findTransactionsPage.type);
       select.getOptions().get(1).click();
    }

    @Then("results table should show no result under Withdrawal")
    public void results_table_should_show_no_result_under_Withdrawal() {
        List<String> countWithdrawal = BrowserUtils.getElementsText(findTransactionsPage.withdrawalColumnData);
        Assert.assertFalse(countWithdrawal.isEmpty());
    }

    @When("user selects type “Withdrawal”")
    public void user_selects_type_Withdrawal() {
        findTransactionsPage.type.click();
        Select select = new Select(findTransactionsPage.type);
        select.getOptions().get(2).click();
    }

    @Then("results table should show no result under Deposit")
    public void results_table_should_show_no_result_under_Deposit() {
        List<String> countDeposit = BrowserUtils.getElementsText(findTransactionsPage.depositColumnData);
        Assert.assertFalse(countDeposit.isEmpty());
    }



}





