package com.smarterspecies.magento2.api.tests;

import com.smarterspecies.magento2.api.payload.Customer;
import com.smarterspecies.magento2.api.payload.UserPayLoad;
import com.smarterspecies.magento2.api.services.UserApiService;
import org.testng.annotations.Test;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;

public class UserRegistrationTest extends BaseTest{

    private final UserPayLoad userPayLoad = new UserPayLoad();
    private final Customer customer = new Customer();
    private final UserApiService userApiService = new UserApiService();

    @Test
    public void testCanRegisterNewUser() {
        //given
        customer.customer(
                userPayLoad.email("postman_" + randomAlphanumeric(2) + "@gorillagroup.com")
                .firstname("Test")
                .lastname("Postman")
                .websiteId(1)
                .groupId(1))
                .password("Q1w2e3r4");
        //when
        userApiService.registerNewUser(customer)

        //then
                .then()
                .assertThat().statusCode(200);
    }
}
