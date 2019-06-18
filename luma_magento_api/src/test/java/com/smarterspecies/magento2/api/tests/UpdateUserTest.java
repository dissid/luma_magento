package com.smarterspecies.magento2.api.tests;

import com.smarterspecies.magento2.api.payloads.tokenPayLoad.TokenPayLoad;
import com.smarterspecies.magento2.api.payloads.updateUserPayLoad.CustomerData;
import com.smarterspecies.magento2.api.payloads.updateUserPayLoad.UpdateUserPayLoad;
import com.smarterspecies.magento2.api.payloads.userPayLoad.Customer;
import com.smarterspecies.magento2.api.services.TokenApiService;
import com.smarterspecies.magento2.api.services.UpdateUserApiService;
import com.smarterspecies.magento2.api.services.UserApiService;
import org.testng.annotations.Test;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;

public class UpdateUserTest extends BaseTest {

    private final Customer customer = new Customer();
    private final UserApiService userApiService = new UserApiService();
    private final UpdateUserApiService updateUserApiService = new UpdateUserApiService();
    private final TokenPayLoad tokenPayLoad = new TokenPayLoad();
    private final TokenApiService tokenApiService = new TokenApiService();
    private final UpdateUserPayLoad updateUserPayLoad = new UpdateUserPayLoad();
    private final CustomerData customerData = new CustomerData();

    @Test
    public void testCanNotUpdateUserDataWithUserToken() {
        String randEmail = "automation_" + randomAlphanumeric(2) + "@gorillagroup.com";
        String firstName = "Automation";
        String lastName = "Test";
        String password = "Q1w2e3r4";
        int websiteId = 1;
        int groupId = 1;

        //given
        customer.setDataForNewCustomer(randEmail, firstName, lastName, websiteId, groupId, password);
        int userId = userApiService.registerNewUser(customer)
                .then()
                .assertThat().statusCode(200)
                .and()
                .extract().response().body().jsonPath().get("id");
        tokenPayLoad.username(randEmail).password(password);
        String token = tokenApiService.getToken(tokenPayLoad);
        //when
        updateUserPayLoad
                .customer(
                        customerData
                                .id(userId)
                                .email(randEmail)
                                .firstname("Automation_Updated")
                                .lastname("Test_Updated")
                                .websiteId(1)
                                .groupId(1));

        updateUserApiService.updateUserData(token, updateUserPayLoad, String.valueOf(userId))
                .then()
                .statusCode(401)
                .and();

    }
}
