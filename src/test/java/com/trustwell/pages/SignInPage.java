package com.trustwell.pages;


import com.trustwell.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// http://localhost:63342/TrustwellTask/src/test/resources/task/login.html
public class SignInPage {

    @FindBy(xpath = "//input[@name='form-username']")
    public WebElement usernameInputBox;

    @FindBy(xpath = "//input[@name='form-password']")
    public WebElement passwordInputBox;

    @FindBy(xpath = "//button[@id='btnLogin']")
    public WebElement continueButton;



    public SignInPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
