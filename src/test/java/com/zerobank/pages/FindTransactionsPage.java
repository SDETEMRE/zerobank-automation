package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.Date;
import java.util.List;

public class FindTransactionsPage extends BasePage{

    public FindTransactionsPage(){
        PageFactory.initElements(Driver.get(), this);
    }
    @FindBy(partialLinkText = "Account Activity")
    public WebElement accountActivityTab;

    @FindBy(partialLinkText = "Find Transactions")
    public WebElement findTransactionsTab;

    @FindBy(id = "aa_fromDate")
    public WebElement fromDate;

    @FindBy(id = "aa_toDate")
    public WebElement toDate;

    @FindBy(css = ".btn.btn-primary")
    public WebElement findButton;

    @FindBy(id = "aa_description")
    public WebElement description;

    @FindBy(id = "aa_type")
    public WebElement type;

    @FindBy(xpath = "(//*[@id=\"filtered_transactions_for_account\"])/table")
    public WebElement table;


    @FindBy(xpath ="(//table[@class='table table-condensed table-hover'])[2]/tbody/tr/td[1]")
    public List<WebElement> dateColumnData;

    @FindBy(xpath ="(//table[@class='table table-condensed table-hover'])[2]/tbody/tr/td[2]")
    public List<WebElement> descriptionColumnData;

    @FindBy(xpath ="(//table[@class='table table-condensed table-hover'])[2]/tbody/tr/td[3]")
    public List<WebElement> depositColumnData;

    @FindBy(xpath ="(//table[@class='table table-condensed table-hover'])[2]/tbody/tr/td[4]")
    public List<WebElement> withdrawalColumnData;

    public void findTrPage() {
        accountActivityTab.click();
        findTransactionsTab.click();

    }

    public void findDate() {
        List<WebElement> dates = (List<WebElement>) table;
        for(WebElement trueDate : dates){
            System.out.println("trueDate.getText() = " + trueDate.getText());
        }

    }
}