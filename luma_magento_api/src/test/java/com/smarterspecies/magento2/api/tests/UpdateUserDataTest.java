package com.smarterspecies.magento2.api.tests;

import com.smarterspecies.magento2.api.payloads.addressPayLoad.AddressesItem;
import com.smarterspecies.magento2.api.payloads.tokenPayLoad.TokenPayLoad;
import com.smarterspecies.magento2.api.payloads.updateUserPayLoad.UpdateUserPayLoad;
import com.smarterspecies.magento2.api.payloads.userPayLoad.Customer;
import com.smarterspecies.magento2.api.services.TokenApiService;
import com.smarterspecies.magento2.api.services.UserApiService;
import com.smarterspecies.magento2.common.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;

public class UpdateUserDataTest extends BaseTest {

    private final Customer customer = new Customer();
    private final UserApiService userApiService = new UserApiService();
    private final TokenPayLoad tokenPayLoad = new TokenPayLoad();
    private final TokenApiService tokenApiService = new TokenApiService();
    private final UpdateUserPayLoad updateUserPayLoad = new UpdateUserPayLoad();


    @Test
    public void testCanUpdateUserFirstNameAndLastName() {

        String randEmail = "automation_" + randomAlphanumeric(3) + "@gorillagroup.com";
        String updated_firstname = "Automation_Updated";
        String updated_lastname = "Test_Updated";

        customer.setNewCustomerData(randEmail, FIRST_NAME, LAST_NAME, WEBSITE_ID, GROUP_ID, PASSWORD);
        tokenPayLoad.username(ADMIN).password(ADMIN_PASS);
        String token = tokenApiService.getAdminToken(tokenPayLoad);

        int userId = userApiService.registerNewUser(customer)
                .then()
                .assertThat().statusCode(200)
                .and()
                .extract().response().body().jsonPath().get("id");


        updateUserPayLoad.addDataForUpdateUser(userId, randEmail, updated_firstname, updated_lastname, WEBSITE_ID, GROUP_ID);
        String result = userApiService.updateUser(token, updateUserPayLoad, String.valueOf(userId))
                .then()
                .statusCode(200)
                .and()
                .extract().response().jsonPath().get("\"firstname\"");
        Assert.assertEquals(result, updated_firstname);
    }

    @Test
    public void testCanAddAddressForUser() {

        String randEmail = "automation_" + randomAlphanumeric(3) + "@gorillagroup.com";
        customer.setNewCustomerData(randEmail, FIRST_NAME, LAST_NAME, WEBSITE_ID, GROUP_ID, PASSWORD);


        int userId = userApiService.registerNewUser(customer)
                .then()
                .assertThat().statusCode(200)
                .and()
                .extract().response().body().jsonPath().get("id");
        tokenPayLoad.username(randEmail).password(PASSWORD);
        String token = tokenApiService.getAdminToken(tokenPayLoad);
        AddressesItem addressesItem = new AddressesItem();

    //// TODO: 29.06.19

    }

}
