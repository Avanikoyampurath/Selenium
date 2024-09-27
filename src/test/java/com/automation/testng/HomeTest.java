package com.automation.testng;

import org.testng.annotations.Test;

public class HomeTest {

    @Test (groups = "smoke")
    public void test1(){
        System.out.println("Home test1");
    }

    @Test (groups = {"smoke","completed"})
    public void test2(){
        System.out.println("Home test2");
    }

    @Test (groups = "completed")
    public void test3(){
        System.out.println("Home test3");
    }

    @Test (groups = "wip")
    public void test4(){
        System.out.println("Home test4");
    }


}
