package com.automation.testng;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class LoginTest extends BaseTest {

    @Test (dataProvider = "valid username")
    public void success(String username,String password)
    {
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
        String expected="Products";
        String actual=driver.findElement(By.xpath("//span[@class='title' and text()='Products']")).getText();
        Assert.assertEquals(actual,expected);


    }

    @Test (dataProvider = "invalid user")
    public void failure(String username,String password) {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
        boolean actual=driver.findElement(By.xpath("//h3")).isDisplayed();
        Assert.assertTrue(actual);

    }

    @DataProvider(name = "valid username")
    public Object [][] validUsername() throws IOException {
        //return new String[][]{{"standard_user","secret_sauce"},{"problem_user","secret_sauce"},{"performance_glitch_user","secret_sauce"},{"error_user","secret_sauce"},{"visual_user","secret_sauce"}};
        XSSFWorkbook workbook=new XSSFWorkbook("src/test/resources/data/credential.xlsx");
        XSSFSheet sheet= workbook.getSheet("PositiveData");

        int rowNum= sheet.getLastRowNum();
        Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(1).getLastCellNum()];
        for (int i=1; i<=rowNum; i++)
        {
            XSSFRow row= sheet.getRow(i);
            for(int j=0; j<row.getLastCellNum();j++)
            {
                XSSFCell cell= row.getCell(j);
                data [i-1][j]=cell.toString();
            }

        }
        return data;

    }

    @DataProvider(name = "invalid user")
    public String [][] invalidUsername(){
        return new String[][]{{"locked_out_user","secret_sauce"}};
    }



}
