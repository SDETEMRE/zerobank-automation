package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.Collections;
import java.util.List;

public class AccountSummaryStepDefs {
    public AccountSummaryStepDefs() {
        PageFactory.initElements(Driver.get(), this);
    }

    @Then("Account Types should be seen")
    public void account_Types_should_be_seen(List<String> expectedTypes) {
        System.out.println(expectedTypes);
        List<String > actualAccountTypes = BrowserUtils.getElementsText( new AccountSummaryPage().accountTypes);
        Assert.assertEquals(expectedTypes,actualAccountTypes);

    }

    @Then("Credit Accounts table must have seen")
    public void credit_Accounts_table_must_have(List<String> CreditAccountColumns) {
        BrowserUtils.waitFor(2);
        List<String> actualColumnNames = BrowserUtils.getElementsText(new AccountSummaryPage().creditAccountsColumns);
        System.out.println(actualColumnNames);
        Assert.assertEquals(CreditAccountColumns,actualColumnNames);

    }

}
