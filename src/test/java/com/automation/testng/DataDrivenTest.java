package com.automation.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenTest {

    @Test(dataProvider = "PositiveDataProvider",priority = 1)
    public void positiveTest(String amount)
    {
        System.out.println("Positive test with "+amount );
    }

    @Test(dataProvider = "NegativeDataProvider",priority = 2)
    public void negativeTest(String amount)
    {
        System.out.println("Negative test with "+amount );
    }

    @DataProvider(name = "PositiveDataProvider")
    public  Object[] getPositiveData()
    {
        Object [] data={"1","100","10.0"};
        return data;
    }

    @DataProvider(name = "NegativeDataProvider")
    public  Object[] getNegativeData()
    {
        Object [] data={"0.9","-5","100.1","abc","10/2","0.0009"};
        return data;
    }
}
