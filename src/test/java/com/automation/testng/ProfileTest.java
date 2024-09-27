package com.automation.testng;

import org.testng.annotations.Test;

public class ProfileTest {

    @Test (groups = "smoke")
    public void test10(){
        System.out.println("Profile test1");
    }

    @Test (groups = "completed")
    public void test11(){
        System.out.println("Profile test2");
    }

    @Test
    public void test12(){
        System.out.println("Profile test3");
    }

    @Test (groups = "wip")
    public void test13(){
        System.out.println("Profile test4");
    }
}
