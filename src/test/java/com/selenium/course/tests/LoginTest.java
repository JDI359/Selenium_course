package com.selenium.course.tests;

import com.opencsv.exceptions.CsvException;
import com.selenium.course.base.TestUtil;
import com.selenium.course.utils.CsvReader;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTest extends TestUtil {

//    WebDriver driver = null;

    @DataProvider(name = "login-data")
    public static Object[][] dataProviderHardcodedData() {
        return new Object[][]{
                {"user1", "pass1"},
                {"user2", "pass2"},
                {"user3", "pass3"},
        };
    }

    @DataProvider(name = "login-data-file")
    public static Object[][] dataProviderFromCsvFile() throws IOException, CsvException {
        return CsvReader.readCsvFile("src/test/resources/login-data.csv");
    }

//    @BeforeTest
//    public void setupDriver(){
//        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
//        driver = new FirefoxDriver();
//    }

    @Test(dataProvider = "login-data-file")
    public void executeSimpleTest(String user, String pass) {
//        driver.get("https://www.saucedemo.com/");

        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys(user);

        WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        password.sendKeys(pass);

        WebElement loginButton = driver.findElement(By.className("btn_action"));
//        loginButton.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", loginButton);
        js.executeScript("arguments[0].click();", loginButton);
    }

//    @AfterTest
//    public void tearDownDriver(){
//        driver.quit();
//    }
}
