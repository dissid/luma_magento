package com.smarterspecies.magento2.ui.tests;

import com.smarterspecies.magento2.ui.MyAccountPage;
import com.smarterspecies.magento2.ui.RegistrationUserPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;


public class RegistrationUserTest extends BaseTest{

    @Test
    void testCanCreateUserAccount() {
        String email = randomAlphanumeric(6);
        MyAccountPage myAccountPage = RegistrationUserPage
                .open()
                .registeredAs(
                        "name",
                        "last_name",
                        email + "@test.com",
                        "Q1w2e3r4",
                        "Q1w2e3r4");
        myAccountPage.contactInformation().waitUntil(visible,5000).shouldHave(text("name last_name"));
    }
}
