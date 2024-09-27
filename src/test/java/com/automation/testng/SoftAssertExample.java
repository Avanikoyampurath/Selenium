package com.automation.testng;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertExample {

    @Test
    public void testSoftAssert()
    {
        SoftAssert softAssert=new SoftAssert();

        softAssert.assertEquals(10,10);
        softAssert.assertTrue(15>=10);
        softAssert.assertEquals(100,100);
        softAssert.assertTrue(9>10);
        softAssert.assertAll();

    }
}
