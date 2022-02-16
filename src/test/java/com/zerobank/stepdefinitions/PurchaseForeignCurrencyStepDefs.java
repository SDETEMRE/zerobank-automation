package com.zerobank.stepdefinitions;

import com.zerobank.pages.PayBillsPage;
import com.zerobank.pages.PurchaseForeignCurrencyPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.cs.Ale;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PurchaseForeignCurrencyStepDefs {

    public PurchaseForeignCurrencyStepDefs() {
        PageFactory.initElements(Driver.get(), this);
    }

    @Given("the user accesses the Purchase foreign currency cash tab")
    public void the_user_accesses_the_Purchase_foreign_currency_cash_tab() {
        new PayBillsPage().purchaseForeignCurrencyTab.click();
    }

    @Then("following currencies should be available")
    public void following_currencies_should_be_available(List<String> expectedDropdownOptions) {

        Select dropDown = new Select(new PurchaseForeignCurrencyPage().currencyTab);
//        List<WebElement> ActualDropdownOptions = dropDown.getOptions();
//
//        List<String> actualDropdown = BrowserUtils.getElementsText(ActualDropdownOptions);
//        BrowserUtils.waitFor(2);
        Assert.assertTrue(BrowserUtils.getElementsText(dropDown.getOptions()).containsAll(expectedDropdownOptions));

    }
    @When("user tries to calculate cost without selecting a currency")
    public void user_tries_to_calculate_cost_without_selecting_a_currency() {

        new PurchaseForeignCurrencyPage().calculateCostBtn.click();
    }

    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {
        Alert alert = Driver.get().switchTo().alert();
        Assert.assertFalse(alert.getText().isEmpty());
    }

    @When("user tries to calculate cost without entering a value")
    public void user_tries_to_calculate_cost_without_entering_a_value() {
        new PurchaseForeignCurrencyPage().calculateCostBtn.click();
        Alert alert = Driver.get().switchTo().alert();
        Assert.assertFalse(alert.getText().isEmpty());
    }



}
