package com.tutorial.selenium;

import com.selenium.webdriver.WebDriverProvider;
import com.tutorial.utilities.PropertyUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SimpleTest {


    private WebDriver driver;
    private WebDriverProvider webDriverProvider = new WebDriverProvider();
    private PropertyUtil pUtil = new PropertyUtil();
    private Helpers helpers;

    @DataProvider(name = "search words")
    public Object[][] data(){
        return new Object[][]{{"micheal jackson",true}};
    }

    @BeforeMethod
    public void beforeMethod(){
        String browser = pUtil.getProperty("browser.name");
        driver = webDriverProvider.getWebDriver(browser);
        helpers = new Helpers(driver);
    }

    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }

    @Test(description = "google search test",dataProvider = "search words")
    public void test2(String searchWord,boolean condition) throws InterruptedException {
        helpers.launchUrl("http://www.google.com/ncr");
        WebElement search_box = helpers.getElement("q","name");
        helpers.type(search_box,searchWord);
        helpers.type(search_box,Keys.TAB);
        WebElement search_button = helpers.getElement("//*[@id=\"tsf\"]/div[2]/div[1]/div[3]/center/input[1]","xpath");
        helpers.click(search_button);
        boolean found = false;
        try {
            WebElement result = helpers.getElement("//h2[contains(text(),'Description')]//following-sibling::span[1]","xpath");
            String resultText = helpers.getText(result);
            Reporter.log("result : \n "+resultText,true);
            found = true;
        }catch (Exception e){
            Reporter.log("results not displayed",true);
            found = false;
        }
        Assert.assertEquals(found,condition,"condition is not satisfied");
    }


}
