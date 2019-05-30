package com.smarterspecies.magento2.ui.tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    @BeforeSuite
    static void setUp(){
        Configuration.baseUrl = "https://magento2.smarterspecies.com";
    }
}
