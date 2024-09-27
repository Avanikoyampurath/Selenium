package com.automation.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class EbayAutomation {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.ebay.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

        driver.findElement(By.id("gh-ac")).sendKeys("laptop");
        driver.findElement(By.id("gh-btn")).submit();

        List<WebElement>laptopLinks=driver.findElements(By.xpath("//ul/li//div[@class='s-item__title']"));
        String originalWindow= driver.getWindowHandle();
        for(WebElement link:laptopLinks)
        {
            link.click();
            Set<String> listOfWindow= driver.getWindowHandles();

            for(String window: listOfWindow)
            {
                if(!window.equals(originalWindow)){
                    driver.switchTo().window(window);
                }
            }
            System.out.println(driver.findElement(By.xpath("//h1/span")).getText());
            System.out.println(driver.findElement(By.xpath("//div[@class='x-price-primary']/span")).getText());
            driver.close();
            driver.switchTo().window(originalWindow);

        }
    }
}
