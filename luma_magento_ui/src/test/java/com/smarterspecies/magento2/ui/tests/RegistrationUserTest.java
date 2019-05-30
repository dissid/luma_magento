package com.smarterspecies.magento2.ui.tests;

import com.smarterspecies.magento2.ui.MyAccountPage;
import com.smarterspecies.magento2.ui.RegistrationUserPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;


public class RegistrationUserTest extends BaseTest{

    @Test
    void testCanCreateUserAccount() {
        MyAccountPage myAccountPage = RegistrationUserPage
                .open()
                .registeredAs(
                        "name",
                        "last name",
                        randomAlphanumeric(6) + "@test.com",
                        "Q1w2e3r4",
                        "Q1w2e3r4");
        myAccountPage.userName().shouldHave(text("Welcome, name last name"));
    }
}
