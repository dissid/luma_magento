package com.smarterspecies.magento2.ui.tests;

import com.codeborne.selenide.WebDriverRunner;
import com.smarterspecies.magento2.api.payloads.userPayLoad.Customer;
import com.smarterspecies.magento2.api.services.UserApiService;
import com.smarterspecies.magento2.common.BaseTest;
import com.smarterspecies.magento2.ui.LoginPage;
import io.qameta.allure.Epic;
import org.openqa.selenium.Cookie;
import org.testng.annotations.Test;

import java.util.Map;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;

@Epic("User Authorization")
public class LoginTest extends BaseTest {
    private final Customer customer = new Customer();
    private final UserApiService userApiService = new UserApiService();
    Map<String, String> cookies;

    @Test
    public void testCanLogin()  {

        String randEmail = "automation_" + randomAlphanumeric(6) + "@gorillagroup.com";
        customer.setNewCustomerData(randEmail, FIRST_NAME, LAST_NAME, WEBSITE_ID, GROUP_ID, PASSWORD);
        String cookies = userApiService.registerNewUser(customer)
                .then()
                .assertThat().statusCode(200).extract().response().getCookie("PHPSESSID");

        LoginPage.open();
        WebDriverRunner.getWebDriver().manage().deleteCookieNamed("PHPSESSID");
        Cookie cookie = new Cookie("PHPSESSID", cookies);
        WebDriverRunner.getWebDriver().manage().addCookie(cookie);

        System.out.println();
      /*  MyAccountPage myAccountPage = LoginPage.open().fillLoginForm(randEmail, PASSWORD);
        myAccountPage.contactInformation()
                .shouldHave(text("Automation Test\n" + randEmail));*/
    }
}
