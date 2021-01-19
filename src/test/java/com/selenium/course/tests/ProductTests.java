package com.selenium.course.tests;

import com.selenium.course.base.TestUtil;
import com.selenium.course.pages.BasePage;
import com.selenium.course.pages.LoginPage;
import com.selenium.course.pages.ProductListerPage;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ProductTests extends TestUtil {

    @Test
    public void executeProductTest(){

        LoginPage loginPage = new LoginPage(driver);
        ProductListerPage productListerPage = loginPage.login("standard_user", "secret_sauce");

        Reporter.log("Login is successful.");

        productListerPage.addToCart("Sauce Labs Backpack");

        //Hard assert
        Assert.assertTrue(productListerPage.isProductPriceCorrect("Sauce Labs Backpack", "$29.99"));

        //Soft asserts
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(productListerPage.isProductPriceCorrect("Sauce Labs Backpack", "$29.99"));
        softAssert.assertTrue(productListerPage.isProductPriceCorrect("Sauce Bike Light", "$222.99"));
        softAssert.assertFalse(productListerPage.isProductPriceCorrect("Sauce Bike Light", "$29.99"));

        softAssert.assertAll();
    }
}
