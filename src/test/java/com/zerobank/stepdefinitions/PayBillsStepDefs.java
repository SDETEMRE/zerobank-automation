package com.zerobank.stepdefinitions;

import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PayBillsStepDefs {

    PayBillsPage payBillsPage = new PayBillsPage();

    @Given("Pay Bills page should have the title {string}")
    public void pay_Bills_page_should_have_the_title(String expectedPayBillsPagetitle) {
        payBillsPage.payBillsTab.click();
        BrowserUtils.waitFor(2);
        Assert.assertEquals(expectedPayBillsPagetitle, Driver.get().getTitle());
    }

    @Then("After successful Pay operation, {string} should be displayed")
    public void after_successful_Pay_operation_should_be_displayed(String expectedSuccessMessage) {
        payBillsPage.payBillsTab.click();
        payBillsPage.successPayOperation();
        Assert.assertEquals(expectedSuccessMessage, payBillsPage.successMessage.getText());
    }

    @Then("Without entering the amount or date, {string} should be displayed")
    public void without_entering_the_amount_or_date_should_be_displayed(String expectedUnsuccessMessage) {

        payBillsPage.unsuccessPayOperation();
        Assert.assertEquals(expectedUnsuccessMessage, payBillsPage.amountTab.getAttribute("validationMessage"));
        System.out.println(payBillsPage.amountTab.getAttribute("validationMessage"));


    }
}
