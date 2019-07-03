package com.smarterspecies.magento2.ui.tests;

import com.smarterspecies.magento2.common.BaseTest;
import com.smarterspecies.magento2.ui.MyAccountPage;
import com.smarterspecies.magento2.ui.RegistrationUserPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;


public class RegistrationUserTest extends BaseTest {

    @Test
    void testCanCreateUserAccount() {
        String randEmail = "automation_" + randomAlphanumeric(6) + "@gorillagroup.com";
        MyAccountPage myAccountPage = RegistrationUserPage
                .open()
                .registeredAs(FIRST_NAME, LAST_NAME, randEmail, PASSWORD, PASSWORD);
        myAccountPage.contactInformation().shouldHave(text(randEmail));
    }
}
