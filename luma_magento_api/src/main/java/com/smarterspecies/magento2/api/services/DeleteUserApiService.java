package com.smarterspecies.magento2.api.services;

import io.restassured.response.Response;

public class DeleteUserApiService extends ApiService {

    public Response deleteUser(String token, String userId){
        return setup()
                .auth().oauth2(token)
                .delete("/rest/V1/customers/" + userId);
    }
}
