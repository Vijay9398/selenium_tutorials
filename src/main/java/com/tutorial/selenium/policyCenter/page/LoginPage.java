package com.tutorial.selenium.policyCenter.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;

    @FindBy(xpath = "//input[contains(@name,'LoginDV-username')]")
    private WebElement username_loc;

    @FindBy(xpath = "//input[contains(@name,'LoginDV-password')]")
    private WebElement password_loc;

    @FindBy(xpath = "//div[contains(@id,'LoginDV-submit')]//div[@role='button']")
    private WebElement login_button;


    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void doLogin(String username,String password){
        username_loc.sendKeys(username);
        password_loc.sendKeys(password);
        login_button.click();
    }


}
