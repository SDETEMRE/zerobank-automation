package com.zerobank.stepdefinitions;

import com.zerobank.pages.DashboardPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;

public class LoginCredantialsStepDefs {

    public LoginCredantialsStepDefs(){
        PageFactory.initElements(Driver.get(), this);
    }


    @Then("Account summary page displayed")
    public void account_summary_page_displayed() {
        Assert.assertTrue(Driver.get().getTitle().contains("Account Summary"));

    }

    @Given("the user logged in {string} and {string}")
    public void the_user_logged_in_and(String user, String passwd) {
       new LoginPage().login(user,passwd);
    }

    @Then("the user should see the message {string}")
    public void the_user_should_see_the_message(String errorMessage) {

        Assert.assertTrue(new LoginPage().errorMessage.getText().equals(errorMessage));
    }

}
