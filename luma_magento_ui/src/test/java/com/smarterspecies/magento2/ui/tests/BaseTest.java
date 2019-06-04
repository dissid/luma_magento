package com.smarterspecies.magento2.ui.tests;

import com.codeborne.selenide.Configuration;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    @BeforeSuite
    static void setUp(){
        RestAssured.baseURI = "https://magento2.smarterspecies.com";
        Configuration.baseUrl = "https://magento2.smarterspecies.com";
    }
}
