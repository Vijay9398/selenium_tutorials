package com.tutorial.testng.hook;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;

public class HookTutorial {

    String accountNumber = "";

    @BeforeMethod
    public void beforeMethod(){
        Reporter.log("Account creation",true);
        accountNumber = RandomStringUtils.randomAlphabetic(8);
    }

    @AfterMethod
    public void afterMethod(){
        Reporter.log("sign out",true);
    }

    @BeforeClass
    public void beforeClass(){
        Reporter.log("before class",true);
    }

    @AfterClass
    public void afterClass(){
        Reporter.log("after class",true);
    }


    @Test
    public void test1(){
        Reporter.log("creating general liability submission with account : "+accountNumber,true);
    }

    @Test
    public void test2(){
        Reporter.log("creating commercial property submission with account : "+accountNumber,true);
    }

}
