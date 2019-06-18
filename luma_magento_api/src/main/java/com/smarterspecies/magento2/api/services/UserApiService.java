package com.smarterspecies.magento2.api.services;

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
}
