package com.smarterspecies.magento2.api.services;

import com.smarterspecies.magento2.api.payload.Customer;
import io.restassured.response.Response;

public class UserApiService extends ApiService {

   public Response registerNewUser(Customer customer){
        return setup()
                .body(customer)
                .when()
                .post("/rest/V1/customers");
    }
}
