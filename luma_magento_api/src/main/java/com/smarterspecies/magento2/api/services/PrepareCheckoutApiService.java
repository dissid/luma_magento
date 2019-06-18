package com.smarterspecies.magento2.api.services;

import com.smarterspecies.magento2.api.payloads.prepareCheckoutPayLoad.PrepareCheckoutPayLoad;
import io.qameta.allure.Step;

public class PrepareCheckoutApiService extends ApiService {
    @Step("Setting shipping information")
    public void setShippingInformation(String token, PrepareCheckoutPayLoad prepareCheckoutPayLoad){
        setup()
                .auth().oauth2(token)
                .body(prepareCheckoutPayLoad)
                .post("/rest/V1/carts/mine/shipping-information")
                .then().statusCode(200);

    }

}
