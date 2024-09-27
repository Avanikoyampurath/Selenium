package com.automation.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class SauceDemo {

    public static void main(String[] args) {

        WebDriver driver=new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@id='login-button']")).submit();
        driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).click();
        driver.findElement(By.xpath("//button[@id='add-to-cart']")).click();
        driver.findElement(By.xpath("//span[@class='shopping_cart_badge']")).click();

        List<WebElement>descList=driver.findElements(By.xpath("//div[@class='cart_item_label']//div[@data-test]"));
        for (WebElement desc:descList)
        {
            System.out.println(desc.getText());
        }
        System.out.println();

        driver.findElement(By.xpath("//button[@id='checkout']")).click();
        driver.findElement(By.xpath("//input[@id='first-name']")).sendKeys("John");
        driver.findElement(By.xpath("//input[@id='last-name']")).sendKeys("Smith");
        driver.findElement(By.xpath("//input[@id='postal-code']")).sendKeys("5656565");
        driver.findElement(By.xpath("//input[@id='continue']")).submit();

        List<WebElement>descViewList=driver.findElements(By.xpath("//div[@class='cart_item_label']//div[@data-test]"));
        for (WebElement desc:descViewList)
        {

            System.out.println(desc.getText());
        }

        System.out.println();

        List<WebElement>overViewList=driver.findElements(By.xpath("//div[@class='summary_info']/div[@data-test]"));
        for (WebElement desc:overViewList)
        {
            System.out.println(desc.getText());
        }

        driver.findElement(By.xpath("//button[@id='finish']")).click();

        System.out.println();

        System.out.println(driver.findElement(By.xpath("//h2")).getText());
        System.out.println(driver.findElement(By.xpath("//div[@class='complete-text']")).getText());


    }
}
