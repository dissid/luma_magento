package com.smarterspecies.magento2.common;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
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
        ProjectConfig config = ConfigFactory.create(ProjectConfig.class, System.getProperties());
        RestAssured.baseURI = config.host();
        Configuration.baseUrl = config.host();
        Configuration.timeout = 5000;
        Configuration.headless = false;
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
    }
    @AfterMethod
    public void stop(){
       Selenide.close();

    }

}
