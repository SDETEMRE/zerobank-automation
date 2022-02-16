package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AccountActivityPageCheckStepDefs {

    @Given("Account Activity page should have the title {string}")
    public void account_Activity_page_should_have_the_title(String title) {
        new AccountActivityPage().accountActivityTab.click();
        Assert.assertEquals(title, Driver.get().getTitle());
    }

    @Given("Account drop down default option should be {string}")
    public void account_drop_down_default_option_should_be(String defaultValue) {

        Select selectedOption = new Select(new AccountActivityPage().dropDownOption);
        Assert.assertEquals(defaultValue,selectedOption.getFirstSelectedOption().getText());
        System.out.println(selectedOption.getFirstSelectedOption().getText());

    }

    @Given("Account drop down should have the following options:")
    public void account_drop_down_should_have_the_following_options(List<String> dropdownOptions) {

        List<String> actualDropdownOptions = BrowserUtils.getElementsText(new AccountActivityPage().dropDownListOptions);
        Assert.assertEquals(dropdownOptions,actualDropdownOptions);
        System.out.println(actualDropdownOptions);

    }

    @Then("Transactions table should have column names")
    public void transactions_table_should_have_column_names(List<String> expectedtransatcionTableColumns) {

        List<String> actualTransactionTableColumns = BrowserUtils.getElementsText(new AccountActivityPage().transactionsTableColumns);
        Assert.assertEquals(expectedtransatcionTableColumns,actualTransactionTableColumns);
        System.out.println(actualTransactionTableColumns);
    }

}
