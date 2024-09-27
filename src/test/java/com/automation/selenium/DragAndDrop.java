package com.automation.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

public class DragAndDrop {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

        WebElement iframe= driver.findElement(By.xpath("//iframe[@class='demo-frame lazyloaded']"));
        driver.switchTo().frame(iframe);

        List<WebElement> imgList=driver.findElements(By.xpath("//ul[@id='gallery']//img"));
        WebElement trash= driver.findElement(By.id("trash"));
        Actions action=new Actions(driver);
        for (WebElement img:imgList){
            action.dragAndDrop(img,trash).pause(1000).build().perform();
        }
    }
}
