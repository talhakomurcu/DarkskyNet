package com.darkskynet.stepdefinitions;

import com.darkskynet.base.BasePage;
import com.darkskynet.base.ConfigReader;
import com.darkskynet.pages.MainPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class MainPageSD {

    @Given("User goes to main page")
    public void goToMainPage() {
        BasePage.initializeDriver();
    }
    @When("User enters location")
    public void enterLocation(){
        MainPage.enterLocation(ConfigReader.getProperty("location"));
    }
    @And("User presses enter")
    public void pressEnter(){
        MainPage.enterSearch();
    }
    @And("User gets lowest temperature")
    public void getLowestTemp(){
        MainPage.getLowestTemp();
    }
    @And("User gets highest temperature")
    public void getHighestTemp(){
        MainPage.getHighestTemp();
    }
    @Then("Verify lowest and highest temps correct")
    public void verifyTemps(){
        Assert.assertTrue(MainPage.verifyTemps());
        MainPage.quit();
    }



}
