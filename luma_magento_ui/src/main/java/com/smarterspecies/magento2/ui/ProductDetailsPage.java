package com.smarterspecies.magento2.ui;

import com.codeborne.selenide.Condition;
import static com.codeborne.selenide.Selenide.$;

public class ProductDetailsPage {

    public ShoppingCartPage editProductQty(int productQty) {
        $(".spinner").waitUntil(Condition.hidden, 60000);
        $("#qty").setValue(String.valueOf(productQty));
        $("#product-updatecart-button").click();
        return new ShoppingCartPage();
    }
}
