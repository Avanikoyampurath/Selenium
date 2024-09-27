package com.automation.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class SearchFlight {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.expedia.co.in/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

        driver.findElement(By.xpath("//a/span[text()='Flights']")).click();
        driver.findElement(By.xpath("//button[@aria-label='Leaving from']")).sendKeys("Thiruvananthapuram (TRV - Trivandrum Intl.) India");
        driver.findElement(By.xpath("//button[@aria-label='Thiruvananthapuram (TRV - Trivandrum Intl.) India']")).click();
        driver.findElement(By.xpath("//button[@aria-label='Going to']")).sendKeys("Kuala Lumpur (KUL - Kuala Lumpur Intl.) Malaysia");
        driver.findElement(By.xpath("//button[@aria-label='Kuala Lumpur (KUL - Kuala Lumpur Intl.) Malaysia']")).click();
        driver.findElement(By.xpath("//button[@name='EGDSDateRange-date-selector-trigger']")).click();

        WebElement startDate = driver.findElement(By.xpath("//table[@aria-label='July 2024']//div[text()='18']"));
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].click();",startDate);

        WebElement endDate = driver.findElement(By.xpath("//table[@aria-label='July 2024']//div[text()='20']"));
        javascriptExecutor.executeScript("arguments[0].click();",endDate);

        driver.findElement(By.xpath("//button[@data-stid='apply-date-selector']")).click();
        driver.findElement(By.xpath("//button[@id='search_button']")).click();

        List<WebElement>offerList=driver.findElements(By.xpath("//li[@data-test-id='offer-listing']"));
        for(WebElement list:offerList){
            System.out.println(list.getText());
        }
    }
}
