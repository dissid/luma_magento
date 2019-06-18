package com.smarterspecies.magento2.api.tests;

import com.smarterspecies.magento2.api.payloads.tokenPayLoad.TokenPayLoad;
import com.smarterspecies.magento2.api.payloads.updateUserPayLoad.CustomerData;
import com.smarterspecies.magento2.api.payloads.updateUserPayLoad.UpdateUserPayLoad;
import com.smarterspecies.magento2.api.payloads.userPayLoad.Customer;
import com.smarterspecies.magento2.api.services.DeleteUserApiService;
import com.smarterspecies.magento2.api.services.TokenApiService;
import com.smarterspecies.magento2.api.services.UpdateUserApiService;
import com.smarterspecies.magento2.api.services.UserApiService;
import org.testng.annotations.Test;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;


public class DeleteUserTest extends BaseTest {

    private final Customer customer = new Customer();
    private final UserApiService userApiService = new UserApiService();
    private final DeleteUserApiService deleteUserApiService = new DeleteUserApiService();
    private final UpdateUserApiService updateUserApiService = new UpdateUserApiService();
    private final TokenPayLoad tokenPayLoad = new TokenPayLoad();
    private final TokenApiService tokenApiService = new TokenApiService();
    private final UpdateUserPayLoad updateUserPayLoad = new UpdateUserPayLoad();
    private final CustomerData customerData = new CustomerData();

    @Test(enabled = false)
    public void testCanDeleteUser() {
        String randEmail = "automation_" + randomAlphanumeric(2) + "@gorillagroup.com";
        String firstName = "Automation";
        String lastName = "Test";
        String password = "Q1w2e3r4";
        int websiteId = 1;
        int groupId = 1;

        //given
        customer.setDataForNewCustomer(randEmail, firstName, lastName, websiteId, groupId, password);
        //when
        int userId = userApiService.registerNewUser(customer)
                .then()
                .assertThat().statusCode(200)
                .and()
                .extract().response().body().jsonPath().get("id");
        //then
        deleteUserApiService.deleteUser(String.valueOf(userId))
                .then().assertThat().statusCode(200);


    }
}
