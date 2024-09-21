package com.trustwell.pages;

import com.trustwell.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class NutrientsDashboardPage {
    @FindBy(xpath = "//button[@id='btnAddNutrient']")
    public WebElement addNutrientButton;

    @FindBy(xpath = "(//input)[1]")
    public WebElement nutrientNameInputField;

    @FindBy(xpath = "(//input)[2]")
    public WebElement nutrientValueInputField;

    @FindBy(xpath = "//button[text()='Submit']")
    public WebElement submitButton;

    @FindBy(xpath = "//td[2]")
    public List<WebElement> nutritionNamesColumn;

    @FindBy(xpath = "//td[3]")
    public List<WebElement> nutritionValuesColumn;

    @FindBy(xpath = "//*[@id='data']//h4")
    public WebElement totalCalories;


    public NutrientsDashboardPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
