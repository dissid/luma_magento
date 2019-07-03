package com.smarterspecies.magento2.api.services;

import com.smarterspecies.magento2.api.payloads.updateUserPayLoad.UpdateUserPayLoad;
import com.smarterspecies.magento2.api.payloads.userPayLoad.Customer;
import io.qameta.allure.Step;
import io.restassured.response.Response;

public class UserApiService extends ApiService {

    @Step("registration a new user")
    public Response registerNewUser(Customer customer) {
        return setup()
                .body(customer)
                .when()
                .post("/rest/V1/customers");
    }
    public Response deleteUser(String token, String userId){
        return setup()
                .auth().oauth2(token)
                .delete("/rest/V1/customers/" + userId);
    }

    public Response updateUser(String token, UpdateUserPayLoad updateUserPayLoad, String userId){
        return setup()
                .auth().oauth2(token)
                .body(updateUserPayLoad)
                .put("/rest/V1/customers/" + userId);

    }
}
