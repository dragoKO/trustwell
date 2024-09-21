package com.trustwell.steps;

import com.trustwell.pages.NutrientsDashboardPage;
import com.trustwell.pages.SignInPage;
import com.trustwell.utility.ConfigurationReader;
import io.cucumber.java.en.*;

import java.util.Map;

public class CalculateNutrients {
    SignInPage signInPage;
    NutrientsDashboardPage nutrientsDashboardPage;

    @Then("I log in with valid credentials")
    public void i_log_in_with_valid_credentials() {
        signInPage = new SignInPage();
        signInPage.usernameInputBox.sendKeys(ConfigurationReader.getProperty("trustwell_username"));
        signInPage.passwordInputBox.sendKeys(ConfigurationReader.getProperty("trustwell_password"));
        signInPage.continueButton.click();
    }

    @When("I select Add Nutrient")
    public void i_select(String string) {
        nutrientsDashboardPage=new NutrientsDashboardPage();
        nutrientsDashboardPage.addNutrientButton.click();
    }

    @When("I enter the following nutrient details:")
    public void i_enter_the_following_nutrient_details(Map<String,String> nutritionDetails) {
        System.out.println(nutritionDetails);
    }

    @Then("I should see the nutrient in the table")
    public void i_should_see_the_nutrient_in_the_table() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("the calories calculation should be correct based on the entered values {string}")
    public void the_calories_calculation_should_be_correct_based_on_the_entered_values(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
