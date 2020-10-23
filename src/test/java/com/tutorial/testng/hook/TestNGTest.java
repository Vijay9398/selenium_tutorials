package com.tutorial.testng.hook;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGTest {

    /**
     *  this is a testng test
     */
    @Test(description = "this is the first test",groups = {"demo","bug"})
    public void test1(){
        int a = 3;
        int b = 2;
        int result = 6;
        int add = a+b;
        Assert.assertEquals(add,result);
    }

    @Test(description = "this is the second test",groups = "demo")
    public void test2() throws Exception {
        int a = 3;
        int b = 2;
        int result = 1;
        int add = a-b;
        Assert.assertEquals(add,result);
        Assert.fail("this is an intentional failure");
    }

    @Test(description = "this is the third test")
    public void test3(){
        int a = 3;
        int b = 2;
        int result = 6;
        int add = a*b;
        if(add == result)
            System.out.println("mul test passed");
        else
            System.out.println("mul test failed");
    }



}
