package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PurchaseForeignCurrencyPage extends BasePage{

    @FindBy(id = "pc_currency")
    public WebElement currencyTab;

    @FindBy(id = "pc_calculate_costs")
    public WebElement calculateCostBtn;

    @FindBy(id = "pc_inDollars_true")
    public WebElement dolarCurrency;



}
