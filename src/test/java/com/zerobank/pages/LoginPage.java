package com.zerobank.pages;

import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{

    public LoginPage(){
        PageFactory.initElements(Driver.get(), this);
    }
    @FindBy(id = "signin_button")
    public WebElement signinButton;

    @FindBy(id = "user_login")
    public WebElement userName;

    @FindBy(id = "user_password")
    public WebElement password;

    @FindBy(name = "submit")
    public WebElement submit;

    @FindBy(css = ".alert.alert-error")
    public WebElement errorMessage;


    public void login(String userNameStr, String passwordStr){
        signinButton.click();
        userName.sendKeys(userNameStr);
        password.sendKeys(passwordStr);
        submit.click();
    }


}
