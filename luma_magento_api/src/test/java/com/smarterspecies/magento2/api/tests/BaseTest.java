package com.smarterspecies.magento2.api.tests;


import io.restassured.RestAssured;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    @BeforeSuite
    public String setUp() {
        return RestAssured.baseURI = "https://magento2.smarterspecies.com";

    }
}
