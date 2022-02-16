package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AccountSummaryPage extends BasePage{

    public AccountSummaryPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(partialLinkText = "Savings")
    public WebElement savingsButton;

    @FindBy(id = "aa_accountId")
    public WebElement dropdownElement;

    @FindBy(partialLinkText = "Brokerage")
    public WebElement brokerageButton;

    @FindBy(partialLinkText = "Checking")
    public WebElement checkingLink;

    @FindBy(partialLinkText = "Credit Card")
    public WebElement creditCard;

    @FindBy(partialLinkText = "Loan")
    public WebElement loan;

    @FindBy(css = ".board-header")
    public List<WebElement> accountTypes;

    @FindBy(xpath = "(//thead)[3]//th")
    public List<WebElement> creditAccountsColumns;



    public String dropDownAccount(int order) {
        Select stateDropdown = new Select(dropdownElement);
        List<WebElement> options = stateDropdown.getOptions();
        String selectedOrder = options.get(order).getText();
        return selectedOrder;
    }
}

