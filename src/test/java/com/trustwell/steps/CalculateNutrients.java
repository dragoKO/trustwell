package com.trustwell.steps;

import com.trustwell.pages.NutrientsDashboardPage;
import com.trustwell.pages.SignInPage;
import com.trustwell.utility.ConfigurationReader;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebElement;


import java.util.List;
import java.util.Map;

public class CalculateNutrients {
    SignInPage signInPage;
    NutrientsDashboardPage nutrientsDashboardPage;
    Map<String, String> nutrients;

    @Then("I log in with valid credentials")
    public void i_log_in_with_valid_credentials() {
        signInPage = new SignInPage();
        signInPage.usernameInputBox.sendKeys(ConfigurationReader.getProperty("trustwell_username"));
        signInPage.passwordInputBox.sendKeys(ConfigurationReader.getProperty("trustwell_password"));
        signInPage.continueButton.click();
    }

    @When("I select Add Nutrient and enter the following nutrient details:")
    public void i_enter_the_following_nutrient_details(DataTable dataTable) {
        nutrients = dataTable.asMaps().get(0);
        nutrientsDashboardPage = new NutrientsDashboardPage();
        nutrients.forEach((k, v) -> {
            if (k.equalsIgnoreCase("protein")) return;
            nutrientsDashboardPage.addNutrientButton.click();
            nutrientsDashboardPage.nutrientNameInputField.sendKeys(k);
            nutrientsDashboardPage.nutrientValueInputField.sendKeys(v);
            nutrientsDashboardPage.submitButton.click();
            System.out.println(k + v);
        });
    }

    @Then("I should see the nutrient in the table")
    public void i_should_see_the_nutrient_in_the_table() {
        List<WebElement> nutritionNamesColumn = nutrientsDashboardPage.nutritionNamesColumn;
        List<WebElement> nutritionValuesColumn = nutrientsDashboardPage.nutritionValuesColumn;
        for (int i = 0; i < nutrients.size(); i++) {
            String nameText = nutritionNamesColumn.get(i).getText();
            String valueText = nutritionValuesColumn.get(i).getText();
            Assert.assertEquals(nutrients.get(nameText), valueText);
        }
    }

    @And("the calories calculation should be correct based on the entered values {string}")
    public void theCaloriesCalculationShouldBeCorrectBasedOnTheEnteredValues(String expectedCalories) {
        String currentCalories = nutrientsDashboardPage.totalCalories.getText();
        int startIndex=currentCalories.indexOf(": ")+1;
        Assert.assertEquals(expectedCalories,currentCalories.substring(startIndex));
    }
}
