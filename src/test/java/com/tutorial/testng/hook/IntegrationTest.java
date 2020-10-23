package com.tutorial.testng.hook;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class IntegrationTest {

    String submission = "";

    @Test(priority = 0)
    public void policyCenterTest(){
        String submission = "1232132";
        Reporter.log("submission created",true);
        this.submission = submission;
    }

    @Test(priority = 1,dependsOnMethods = "policyCenterTest")
    public void billingCenterTest(){
        Reporter.log("suspense payment is created for : "+submission,true);
    }



}
