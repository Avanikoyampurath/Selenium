package com.automation.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class JSExec {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.ebay.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

        WebElement searchBx= driver.findElement(By.id("gh-ac"));
        //addBorder(searchBx,driver);
        searchBx.sendKeys("laptop");

        WebElement searchBtn= driver.findElement(By.id("gh-btn"));
        //addBorder(searchBtn,driver);
        searchBtn.click();
        windowScroll(driver);


    }
    public static void addBorder(WebElement element,WebDriver driver){
        JavascriptExecutor javascriptExecutor=(JavascriptExecutor) driver;
        javascriptExecutor.executeScript("argument[0].style.border='2px solid red';",element);
    }
    public static void windowScroll(WebDriver driver){
        for (int i=1;i<=10;i++){
            JavascriptExecutor javascriptExecutor=(JavascriptExecutor) driver;
            javascriptExecutor.executeScript("window.scrollBy(0,250)");
        }
    }
}
