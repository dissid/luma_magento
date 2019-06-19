package com.smarterspecies.magento2.api.payloads.addItemsToCartPayload;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.smarterspecies.magento2.api.payloads.prepareCheckoutPayLoad.AddressInformation;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.annotation.Generated;

@Getter
@Setter
@Accessors(fluent = true)
@Generated("com.robohorse.robopojogenerator")
public class AddItemsToCartPayLoad {

    @JsonProperty("cartItem")
    private CartItem cartItem;

    @Override
    public String toString() {
        return "" + cartItem;
    }
    public AddItemsToCartPayLoad setProductToCart(String productSku, int qty, String quoteId){
        return  cartItem(new CartItem()
                .sku(productSku)
                .qty(1)
                .quoteId(quoteId));
    }
}