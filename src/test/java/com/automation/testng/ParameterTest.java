package com.automation.testng;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTest {

    @Parameters({"browser","password"})
    @Test
    public void test1(String browser){

        System.out.println(browser);

    }
}
