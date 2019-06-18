package com.smarterspecies.magento2.api.services;

import com.smarterspecies.magento2.api.payloads.addItemsToCartPayload.AddItemsToCartPayLoad;

public class AddItemsToCartApiService extends ApiService {

    public void addingProductToCart(AddItemsToCartPayLoad addItemsToCartPayLoad, String token) {
        setup()
                .auth().oauth2(token)
                .body(addItemsToCartPayLoad)
                .post("/rest/V1/carts/mine/items")
                .then()
                .assertThat().statusCode(200);


    }
}
