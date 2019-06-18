package com.smarterspecies.magento2.api.tests;

import com.smarterspecies.magento2.api.payloads.addItemsToCartPayload.AddItemsToCartPayLoad;
import com.smarterspecies.magento2.api.payloads.addItemsToCartPayload.CartItem;
import com.smarterspecies.magento2.api.payloads.createOrderPayLoad.BillingAddress;
import com.smarterspecies.magento2.api.payloads.createOrderPayLoad.CreateOrderPayLoad;
import com.smarterspecies.magento2.api.payloads.createOrderPayLoad.PaymentMethod;
import com.smarterspecies.magento2.api.payloads.tokenPayLoad.TokenPayLoad;
import com.smarterspecies.magento2.api.payloads.userPayLoad.Customer;
import com.smarterspecies.magento2.api.payloads.userPayLoad.UserPayLoad;
import com.smarterspecies.magento2.api.services.AddItemsToCartApiService;
import com.smarterspecies.magento2.api.services.QuoteApiService;
import com.smarterspecies.magento2.api.services.TokenApiService;
import com.smarterspecies.magento2.api.services.UserApiService;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;

public class RegistrationUserTest extends BaseTest {

    private final UserPayLoad userPayLoad = new UserPayLoad();
    private final Customer customer = new Customer();
    private final UserApiService userApiService = new UserApiService();


    @Test
    public void testCanRegisterNewUser() {

        //given
        customer.customer(
                userPayLoad.email("automation_" + randomAlphanumeric(2) + "@gorillagroup.com")
                        .firstname("Automation")
                        .lastname("Test")
                        .websiteId(1)
                        .groupId(1))
                .password("Q1w2e3r4");
        //when
        userApiService.registerNewUser(customer)

                //then
                .then()
                .assertThat().statusCode(200);

    }

    @Test
    public void testCanNotRegisterNewUserWithoutData() {
        //given
        customer.customer(
                userPayLoad.email("")
                        .firstname("")
                        .lastname(""))
                .password("Q1w2e3r4");
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
        String randEmail = "automation_" + randomAlphanumeric(2) + "@gorillagroup.com";
        //given
        customer.customer(
                userPayLoad.email(randEmail)
                        .firstname("Automation")
                        .lastname("Test")
                        .websiteId(1)
                        .groupId(1))
                .password("Q1w2e3r4");

        userApiService.registerNewUser(customer)
                .then()
                .assertThat().statusCode(200);
        //when
        customer.customer(
                userPayLoad.email(randEmail)
                        .firstname("Automation")
                        .lastname("Test")
                        .websiteId(1)
                        .groupId(1))
                .password("Q1w2e3r4");
        //then
        String message = userApiService.registerNewUser(customer)
                .then()
                .assertThat().statusCode(400)
                .and()
                .extract().response().getBody().asString();
        Assert.assertEquals(message, "{\"message\":\"A customer with the same email address already exists in an associated website.\"}");

    }

    @Test
    public void testCanNewUserTwice() {
        String randEmail = "automation_" + randomAlphanumeric(2) + "@gorillagroup.com";
        //given
        customer.customer(
                userPayLoad.email(randEmail)
                        .firstname("Automation")
                        .lastname("Test")
                        .websiteId(1)
                        .groupId(1))
                .password("Q1w2e3r4");

        userApiService.registerNewUser(customer)
                .then()
                .assertThat().statusCode(200);
        //when
        customer.customer(
                userPayLoad.email(randEmail)
                        .firstname("Automation")
                        .lastname("Test")
                        .websiteId(1)
                        .groupId(1))
                .password("Q1w2e3r4");
        //then
        String message = userApiService.registerNewUser(customer)
                .then()
                .assertThat().statusCode(400)
                .and()
                .extract().response().getBody().asString();
        Assert.assertEquals(message, "{\"message\":\"A customer with the same email address already exists in an associated website.\"}");

    }


}
