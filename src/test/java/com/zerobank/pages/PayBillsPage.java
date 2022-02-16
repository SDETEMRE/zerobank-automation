package com.zerobank.pages;

import io.cucumber.java.eo.Se;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PayBillsPage extends BasePage{

    @FindBy(partialLinkText = "Pay Bills")
    public WebElement payBillsTab;

    @FindBy(id = "alert_content")
    public WebElement successMessage;

    @FindBy(xpath = "//*[@id='sp_payee']/option")
    public List<WebElement> payeeDropdownOptions;

    @FindBy(xpath = "//*[@id=\"sp_account\"]/option")
    public List<WebElement> accountDropdownOptions;

    @FindBy(id = "sp_amount")
    public WebElement amountTab;

    @FindBy(id = "sp_date")
    public WebElement dateTab;

    @FindBy(id = "sp_description")
    public WebElement descriptionTab;

    @FindBy(id = "pay_saved_payees")
    public WebElement paySubmitTab;

    @FindBy(linkText = "Add New Payee")
    public WebElement addNewPayeeTab;

    @FindBy(linkText = "Purchase Foreign Currency")
    public WebElement purchaseForeignCurrencyTab;

    public void successPayOperation(){
        new PayBillsPage().payeeDropdownOptions.get(0).click();
        new PayBillsPage().accountDropdownOptions.get(0).click();
        new PayBillsPage().amountTab.sendKeys("50");
        new PayBillsPage().dateTab.sendKeys("02-02-2022");
        new PayBillsPage().descriptionTab.sendKeys("Gift");
        new PayBillsPage().paySubmitTab.click();
        }

        public void unsuccessPayOperation(){
            new PayBillsPage().payeeDropdownOptions.get(0).click();
            new PayBillsPage().accountDropdownOptions.get(0).click();
            new PayBillsPage().amountTab.sendKeys("");
            new PayBillsPage().dateTab.sendKeys("02-02-2022");
            new PayBillsPage().descriptionTab.sendKeys("Gift");
            new PayBillsPage().paySubmitTab.click();
        }
    }
