package com.smarterspecies.magento2.api.services;

import io.qameta.allure.Step;

public class QuoteApiService extends ApiService {
    @Step("Getting quote id")
    public String getQuoteId(String token) {
        return setup()
                .auth().oauth2(token)
                .post("/rest/V1/carts/mine")
                .then()
                .extract().response().asString();
    }
}
