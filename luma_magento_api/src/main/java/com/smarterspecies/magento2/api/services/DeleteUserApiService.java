package com.smarterspecies.magento2.api.services;

import io.restassured.response.Response;

public class DeleteUserApiService extends ApiService {

    public Response deleteUser(String userId){
        return setup()
                .delete("/rest/V1/customers/" + userId);
    }
}
