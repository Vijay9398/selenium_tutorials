package com.selenium.webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;

public class WebDriverProvider {

    public WebDriver getWebDriver(String name){
        WebDriver driver = null;
        switch (name){
            case "chrome":
                driver = getChromedriver();
                break;
            case "firefox":
                driver = getFirefoxDriver();
                break;
            default:
                Reporter.log("not a relevant name , so launching chrome",true);
                driver = getChromedriver();
        }
        driver.manage().window().maximize();
        return driver;
    }


    public ChromeDriver getChromedriver(){
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        return driver;
    }

    public FirefoxDriver getFirefoxDriver(){
        WebDriverManager.firefoxdriver().setup();
        FirefoxDriver driver = new FirefoxDriver();
        return driver;
    }



}
