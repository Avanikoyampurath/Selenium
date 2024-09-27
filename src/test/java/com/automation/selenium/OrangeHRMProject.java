package com.automation.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Random;

public class OrangeHRMProject {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

        //login
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        //add user
        driver.findElement(By.xpath("//span[text()='Admin']")).click();
        driver.findElement(By.xpath("//div[@class='orangehrm-header-container']/button[@type='button']")).click();
        driver.findElement(By.xpath("//label[text()='User Role']/parent::*/following-sibling::div")).click();
        //Enter details
        driver.findElement(By.xpath("//span[text()='ESS']")).click();
        driver.findElement(By.xpath("//input[@placeholder='Type for hints...']")).sendKeys("Joy");
        driver.findElement(By.xpath("//div[@class='oxd-autocomplete-option']/span")).click();
        driver.findElement(By.xpath("//label[text()='Status']/../following-sibling::div")).click();
        driver.findElement(By.xpath("//span[text()='Enabled']")).click();

        //random username generate
        Random random = new Random();
        String userName = "test" + random.nextInt(1000);
        System.out.println(userName);
        driver.findElement(By.xpath("//label[text()='Username']/../following-sibling::div/input")).sendKeys(userName);
        driver.findElement(By.xpath("//label[text()='Password']/../following-sibling::div/input")).sendKeys("test1234");
        driver.findElement(By.xpath("//label[text()='Confirm Password']/../following-sibling::div/input")).sendKeys("test1234");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(10000);

        //logout
        driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']")).click();
        driver.findElement(By.xpath("//a[text()='Logout']")).click();

        //login with username
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(userName);
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("test1234");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        //logout
        driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']")).click();
        driver.findElement(By.xpath("//a[text()='Logout']")).click();

        //login admin
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        //remove user
        driver.findElement(By.xpath("//span[text()='Admin']")).click();
        driver.findElement(By.xpath("//label[text()='Username']/../following-sibling::div/input")).sendKeys(userName);
        driver.findElement(By.xpath("//button[@type='submit' and text()=' Search ']")).click();
        driver.findElement(By.xpath("//i[@class='oxd-icon bi-check oxd-checkbox-input-icon']")).click();
        driver.findElement(By.xpath(" //button[text()=' Delete Selected '] ")).click();
        //driver.findElement(By.xpath("//i[@class='oxd-icon bi-trash'])")).click();
        driver.findElement(By.xpath("//button[text()=' Yes, Delete ']")).click();





    }
}
