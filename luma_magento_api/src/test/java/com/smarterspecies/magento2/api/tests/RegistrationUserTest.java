package com.smarterspecies.magento2.api.tests;

import com.smarterspecies.magento2.api.payloads.userPayLoad.Customer;
import com.smarterspecies.magento2.api.payloads.userPayLoad.UserPayLoad;
import com.smarterspecies.magento2.api.services.UserApiService;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;

public class RegistrationUserTest extends BaseTest {

    private final Customer customer = new Customer();
    private final UserApiService userApiService = new UserApiService();


    @Test
    public void testCanRegisterNewUser() {
        //given
        String randEmail = "automation_" + randomAlphanumeric(3) + "@gorillagroup.com";
        customer.setNewCustomerData(randEmail, FIRST_NAME, LAST_NAME, WEBSITE_ID, GROUP_ID, PASSWORD);

        //then
        userApiService.registerNewUser(customer)
                .then()
                .assertThat().statusCode(200);

    }

    @Test
    public void testCanNotRegisterNewUserWithoutData() {
        //given
        customer.setNewCustomerData("", "", "", WEBSITE_ID, GROUP_ID, PASSWORD);
        //then
        String message = userApiService
                .registerNewUser(customer)
                .then()
                .assertThat().statusCode(400)
                .and()
                .extract().response().getBody().asString();
        Assert.assertEquals(message, "{\"message\":\"The customer email is missing. Enter and try again.\"}");
    }

    @Test
    public void testCanNotRegisterNewUserTwice() {
        String randEmail = "automation_" + randomAlphanumeric(3) + "@gorillagroup.com";
        //given
        customer.setNewCustomerData(randEmail, FIRST_NAME, LAST_NAME, WEBSITE_ID, GROUP_ID, PASSWORD);
        //when
        userApiService.registerNewUser(customer)
                .then()
                .assertThat().statusCode(200);
        //then
        String message = userApiService.registerNewUser(customer)
                .then()
                .assertThat().statusCode(400)
                .and()
                .extract().response().getBody().asString();
        Assert.assertEquals(message, "{\"message\":\"A customer with the same email address already exists in an associated website.\"}");

    }

}
