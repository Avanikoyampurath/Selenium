package com.automation.selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HandlingAlerts
{
    public static void main(String[] args)
    {
        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

        WebElement first= driver.findElement(By.xpath("//button[text()='Click for JS Alert']"));
        first.click();
        Alert alert1=driver.switchTo().alert();
        alert1.accept();

        WebElement second= driver.findElement(By.xpath("//button[text()='Click for JS Confirm']"));
        second.click();
        Alert alert2=driver.switchTo().alert();
        alert2.dismiss();

        WebElement third= driver.findElement(By.xpath("//button[text()='Click for JS Prompt']"));
        third.click();
        Alert alert3=driver.switchTo().alert();
        alert3.sendKeys("JS Alert");
        alert3.accept();


    }
}
