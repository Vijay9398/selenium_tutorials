package com.tutorial.testng.hook;


import org.junit.Test;

public class JunitTest {

    String submission = "no submission";

    @Test()
    public void test_01(){
        String submission = "1232132";
        System.out.println("submission created");
        this.submission = submission;
    }

    @Test()
    public void test_02(){
        System.out.println("suspense payment is created for : "+submission);
    }

}
