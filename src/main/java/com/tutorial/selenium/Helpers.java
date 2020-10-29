package com.tutorial.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class Helpers {

    private WebDriver driver;
    public Helpers(WebDriver driver) {
        this.driver = driver;
    }

    public void click(WebElement element){
        Reporter.log("Clicking "+element,true);
        element.click();
    }

    public void type(WebElement element,String keys){
        Reporter.log("Entering text : "+keys+" in this element : "+element,true);
        element.sendKeys(keys);
    }

    public void type(WebElement element, Keys keys){
        Reporter.log("Entering text : "+keys,true);
        element.sendKeys(keys);
    }

    public void selectOptionUsingText(WebElement element,String text){
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    public void selectOptionUsingIndex(WebElement element,int index){
        Select select = new Select(element);
        select.selectByIndex(index);
    }

    public void mouseHover(WebElement element){
        Reporter.log("mouse hovering",true);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }

    public String getText(WebElement element){
        String text = element.getText();
        Reporter.log("text retrieved : "+text,true);
        return text;
    }

    public void launchUrl(String url){
        driver.get(url);
        Reporter.log("opening url : "+url,true);
    }

    public WebElement getElement(String locator,String type){
        By loc;
        switch(type){
            case "xpath":
                loc = By.xpath(locator);
                break;
            case "id":
                loc = By.id(locator);
                break;
            case "name":
                loc = By.name(locator);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.presenceOfElementLocated(loc));
        WebElement element = driver.findElement(loc);
        return element;
    }


}
