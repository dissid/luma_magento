package com.smarterspecies.magento2.api.services;

import com.smarterspecies.magento2.api.payloads.tokenPayLoad.TokenPayLoad;
import io.qameta.allure.Step;

public class TokenApiService extends ApiService {

    @Step("get token {token}")
    public String getToken(TokenPayLoad token) {
        return setup()
                .body(token)
                .post("/rest/V1/integration/customer/token")
                .then()
                .extract().response().asString().replace("\"", "");
    }
}
