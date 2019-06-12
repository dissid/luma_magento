package com.smarterspecies.magento2.ui.tests;

import com.codeborne.selenide.Condition;
import com.smarterspecies.magento2.api.payload.Customer;
import com.smarterspecies.magento2.api.payload.UserPayLoad;
import com.smarterspecies.magento2.api.services.UserApiService;
import com.smarterspecies.magento2.ui.LoginPage;
import com.smarterspecies.magento2.ui.MyAccountPage;
import org.testng.annotations.Test;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;

public class LoginTest extends BaseTest {
    private final Customer customer = new Customer();
    private final UserPayLoad userPayLoad = new UserPayLoad();
    private final UserApiService userApiService = new UserApiService();

    @Test
    public void testCanLogin() {
        String email = randomAlphanumeric(2);
        //given
        customer.customer(
                userPayLoad.email("automation_" + email + "@test.com")
                        .firstname("Test")
                        .lastname("Automation")
                        .websiteId(1)
                        .groupId(1))
                .password("Q1w2e3r4");
        userApiService.registerNewUser(customer)
                .then()
                .assertThat().statusCode(200);
        //when
        MyAccountPage myAccountPage = LoginPage.open().fillLoginForm("automation_" + email + "@gorillagroup.com", "Q1w2e3r4");
        //then
        myAccountPage.contactInformation()
                .shouldHave(Condition.text("Test Automation\nautomation_" + email + "@test.com"));

    }
}
