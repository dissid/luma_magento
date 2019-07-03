package com.smarterspecies.magento2.common;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.restassured.RestAssured;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    protected final static String ADMIN = "mage_gorilla";
    protected final static String ADMIN_PASS = "Monkey12345";

    protected final static String FIRST_NAME = "Automation";
    protected final static String LAST_NAME = "Test";
    protected final static String PASSWORD = "Q1w2e3r4";
    protected final static int WEBSITE_ID = 1;
    protected final static int GROUP_ID = 1;

    @BeforeSuite
    public void setUp() {
        RestAssured.baseURI = "https://magento2.smarterspecies.com";
        Configuration.baseUrl = "https://magento2.smarterspecies.com";
        Configuration.timeout = 5000;
        Configuration.headless = true;
    }
    @AfterMethod
    public void stop(){
       Selenide.close();

    }

}
