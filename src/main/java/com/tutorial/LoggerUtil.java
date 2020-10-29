package com.tutorial;

import org.testng.Reporter;

public class LoggerUtil {

    public void info(String message){
        Reporter.log(message,true);
    }

}
