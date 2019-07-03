package com.smarterspecies.magento2.ui.tests;

import com.smarterspecies.magento2.api.payloads.userPayLoad.Customer;
import com.smarterspecies.magento2.api.services.UserApiService;
import com.smarterspecies.magento2.common.BaseTest;
import com.smarterspecies.magento2.ui.LoginPage;
import com.smarterspecies.magento2.ui.MyAccountPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;

public class LoginTest extends BaseTest {
    private final Customer customer = new Customer();
    private final UserApiService userApiService = new UserApiService();

    @Test
    public void testCanLogin()  {

        String randEmail = "automation_" + randomAlphanumeric(6) + "@gorillagroup.com";
        customer.setNewCustomerData(randEmail, FIRST_NAME, LAST_NAME, WEBSITE_ID, GROUP_ID, PASSWORD);
        userApiService.registerNewUser(customer)
                .then()
                .assertThat().statusCode(200);

        MyAccountPage myAccountPage = LoginPage.open().fillLoginForm(randEmail, PASSWORD);
        myAccountPage.contactInformation()
                .shouldHave(text("Automation Test\n" + randEmail));
    }
}
