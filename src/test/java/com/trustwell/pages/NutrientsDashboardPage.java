package com.trustwell.pages;

import com.trustwell.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NutrientsDashboardPage {
    @FindBy(xpath = "//button[@id='btnAddNutrient']")
    public WebElement addNutrientButton;

    @FindBy(xpath = "(//input)[1]")
    public WebElement nutrientNameInputField;

    @FindBy(xpath = "(//input)[2]")
    public WebElement nutrientValueInputField;

    @FindBy(xpath = "//button[text()='Submit']")
    public WebElement submitButton;




    public NutrientsDashboardPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
