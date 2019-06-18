package com.smarterspecies.magento2.api.tests;

import com.smarterspecies.magento2.api.payloads.tokenPayLoad.TokenPayLoad;
import com.smarterspecies.magento2.api.payloads.updateUserPayLoad.UpdateUserPayLoad;
import com.smarterspecies.magento2.api.payloads.userPayLoad.Customer;
import com.smarterspecies.magento2.api.payloads.userPayLoad.UserPayLoad;
import com.smarterspecies.magento2.api.services.TokenApiService;
import com.smarterspecies.magento2.api.services.UpdateUserApiService;
import com.smarterspecies.magento2.api.services.UserApiService;
import org.testng.annotations.Test;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;

public class UpdateUserTest extends BaseTest {

    private final UserPayLoad userPayLoad = new UserPayLoad();
    private final Customer customer = new Customer();
    private final UserApiService userApiService = new UserApiService();
    private final UpdateUserApiService updateUserApiService = new UpdateUserApiService();
    private final TokenPayLoad tokenPayLoad = new TokenPayLoad();
    private final TokenApiService tokenApiService = new TokenApiService();
    private final UpdateUserPayLoad updateUserPayLoad = new UpdateUserPayLoad();


    @Test(enabled = false)
    public void testCanUpdateUserData() {
        String randEmail = "automation_" + randomAlphanumeric(2) + "@gorillagroup.com";
        String password = "Q1w2e3r4";
        //given
        customer.customer(
                userPayLoad.email(randEmail)
                        .firstname("Automation")
                        .lastname("Test")
                        .websiteId(1)
                        .groupId(1))
                .password(password);
        tokenPayLoad.username(randEmail).password(password);
        String token = tokenApiService.getToken(tokenPayLoad);
        String userId = userApiService.registerNewUser(customer)
                .then()
                .assertThat().statusCode(200)
                .and()
                .extract().response().body().jsonPath().get("id");

        //when

        updateUserApiService.updateUserData(token,customer,userId);

    }
}
