package com.smarterspecies.magento2.api.tests;


import io.restassured.RestAssured;
import org.testng.annotations.BeforeSuite;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;

public class BaseTest {
    final static String ADMIN = "mage_gorilla";
    final static String ADMIN_PASS = "Monkey12345";

    final static String RAND_EMAIL = "automation_" + randomAlphanumeric(3) + "@gorillagroup.com";
    final static String FIRST_NAME = "Automation";
    final static String LAST_NAME= "Test";
    final static String PASSWORD = "Q1w2e3r4";
    final static int WEBSITE_ID = 1;
    final static int GROUP_ID = 1;

    @BeforeSuite
    public String setUp() {
        return RestAssured.baseURI = "https://magento2.smarterspecies.com";

    }
}
