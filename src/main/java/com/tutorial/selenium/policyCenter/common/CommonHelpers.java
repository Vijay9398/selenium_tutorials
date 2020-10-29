package com.tutorial.selenium.policyCenter.common;

import com.tutorial.LoggerUtil;
import org.openqa.selenium.WebDriver;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Set;

public class CommonHelpers {

    private WebDriver driver;
    private LoggerUtil log = new LoggerUtil();

    public CommonHelpers(WebDriver driver) {
        this.driver = driver;
    }

    // method related url

    public void launch(String url){
        log.info("launching url : "+url);
        driver.get(url);
    }

    public String getUrl(){
        String url = driver.getCurrentUrl();
        return url;
    }

    public int getUrlStatus(String url) throws Exception {
        HttpURLConnection connection;
        connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setConnectTimeout(5000);
        connection.connect();
        int status = connection.getResponseCode();
        return status;
    }

    public void navigateTo(String url){
       log.info("navigating to url : "+url);
       driver.navigate().to(url);
    }

    public void refreshPage(){
        log.info("refreshing the page");
        driver.navigate().refresh();
    }


    public Set<String> getWindows(){
        Set<String> windows = driver.getWindowHandles();
        return windows;
    }


    public void shiftToWindow(String windowHandle){
        driver.switchTo().window(windowHandle);
    }



}
