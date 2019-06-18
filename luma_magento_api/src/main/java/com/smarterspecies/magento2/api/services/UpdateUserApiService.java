package com.smarterspecies.magento2.api.services;

import com.smarterspecies.magento2.api.payloads.userPayLoad.Customer;
import io.restassured.response.Response;

public class UpdateUserApiService extends ApiService {

    public Response updateUserData(String token, Customer customer, String userId){
        return setup()
                .auth().oauth2(token)
                .body(customer)
                .post("/rest/V1/customers/" + userId);

    }
}
