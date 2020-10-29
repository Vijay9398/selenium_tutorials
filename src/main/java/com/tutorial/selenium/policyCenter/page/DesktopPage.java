package com.tutorial.selenium.policyCenter.page;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DesktopPage {

    private WebDriver driver;

    @FindBy(xpath = "//div[contains(@id,'TabBar-DesktopTab')]")
    private WebElement desktop_tab;

    public DesktopPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void assertDesktopPage(){
        Assert.assertTrue(desktop_tab.isDisplayed());
    }

}
