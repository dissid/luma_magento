package com.smarterspecies.magento2.api.services;

import com.smarterspecies.magento2.api.payloads.createOrderPayLoad.CreateOrderPayLoad;
import io.qameta.allure.Step;
import io.restassured.response.Response;

public class CreateOrderApiService extends ApiService {
    @Step("Placing order")
    public Response placeOrder(String token, CreateOrderPayLoad createOrderPayLoad) {
        return setup()
                .auth().oauth2(token)
                .body(createOrderPayLoad)
                .post("/rest/V1/carts/mine/payment-information")
                .then()
                .extract().response();
    }

}
