package com.zerobank.stepdefinitions;

import com.zerobank.pages.AddNewPayeePage;
import com.zerobank.pages.DashboardPage;
import com.zerobank.pages.FindTransactionsPage;
import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;

public class AddNewPayeeStepDefs {

    public AddNewPayeeStepDefs() {
        PageFactory.initElements(Driver.get(), this);
    }

    FindTransactionsPage findTransactionsPage = new FindTransactionsPage();
    PayBillsPage payBillsPage = new PayBillsPage();
    AddNewPayeePage addNewPayeePage = new AddNewPayeePage();

    @Given("the user accesses the Pay Bills tab")
    public void the_user_accesses_the_Pay_Bills_tab() {
       new DashboardPage().navigateTo("Pay Bills");
    }

    @Given("Add New Payee tab")
    public void add_New_Payee_tab() {
        payBillsPage.addNewPayeeTab.click();
    }

    @Given("creates new payee using following information")
    public void creates_new_payee_using_following_information(Map<String,String> userInfo) {

        addNewPayeePage.payeeName.sendKeys(userInfo.get("Payee Name"));
        addNewPayeePage.payeeAddress.sendKeys(userInfo.get("Payee Address"));
        addNewPayeePage.payeeAccount.sendKeys(userInfo.get("Account"));
        addNewPayeePage.addNewPayeeBtn.click();

    }
    @Then("message {string} should be displayed")
    public void message_should_be_displayed(String message) {

        Assert.assertEquals(message,addNewPayeePage.alertContent.getText());

    }




}
