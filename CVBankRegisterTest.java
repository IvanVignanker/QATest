package com.company.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CVBankRegisterTest {
    WebDriver driver;

    @BeforeMethod
    public void initTest() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("http://cv-app-test.herokuapp.com/");
        Thread.sleep(4000);
    }

    @Test
    public void registrationTest() throws InterruptedException {
        driver.findElements(By.xpath("//*[@class='btn btn-danger']")).get(1).click();
        Thread.sleep(1000);
        WebElement firstNameField = driver.findElement(By.cssSelector
                ("#firstName"));
        fillField(firstNameField, "Ivan");
        Thread.sleep(1000);

        WebElement lastNameField = driver.findElement(By.cssSelector("#lastName"));
        Thread.sleep(500);
        fillField(lastNameField, "Vignanker");
        Thread.sleep(500);

        WebElement emailField = driver.findElement(By.xpath("//input[@ng-reflect-name='email']"));
        fillField(emailField, "i.vignanker@gmail.com");
        Thread.sleep(500);

        WebElement phoneField = driver.findElement(By.xpath("//input[@placeholder='phone']"));
        fillField(phoneField, "+972546055297");
        Thread.sleep(500);

        WebElement  passwordField = driver.findElement(By.cssSelector("#password"));
        fillField(passwordField, "12345678");
        Thread.sleep(500);

        WebElement confirmPasswordField = driver.findElement(By.xpath("//input[@ng-reflect-name='confirmPass']"));
        fillField(confirmPasswordField, "12345678");
        Thread.sleep(500);

        WebElement proceedButton = driver.findElement(By.cssSelector("[class='btn btn-secondary']"));
        proceedButton.click();
        Thread.sleep(4000);
        System.out.println("Error message: " + driver.findElements(By.cssSelector(".err-message")).get(0).getText());

    }


    public void fillField(WebElement element, String value){
        element.clear();
        element.click();
        element.sendKeys(value);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}

