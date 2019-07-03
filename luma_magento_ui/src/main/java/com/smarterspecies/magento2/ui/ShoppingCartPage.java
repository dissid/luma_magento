package com.smarterspecies.magento2.ui;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class ShoppingCartPage {

    public static ShoppingCartPage open() {
        Selenide.open("/checkout/cart/");
        return new ShoppingCartPage();
    }

    public ShoppingCartPage updateProductQty(int productQty) {
        $(".control.qty input").setValue(String.valueOf(productQty));
        $("button[value='update_qty']").click();
        return this;
    }
    public SelenideElement qtyField(){
        return $(".control.qty input");
    }
    public ShoppingCartPage removeProduct(){
        $(".actions-toolbar a[title='Remove item']").click();
        return this;
    }
    public SelenideElement shoppingCart(){
        return $(".cart-empty");
    }

    public ProductDetailsPage editProduct(){
        $(".action.action-edit").click();
        return new ProductDetailsPage();
    }
    public ShoppingCartPage openEstimateShippingAndTaxBlock(){
        $("#block-shipping-heading").click();
        return this;
    }
    public ShoppingCartPage selectCountry(String country){

        $("select[name='country_id']").shouldBe(visible).selectOptionContainingText(country);
        return this;
    }
    public ShoppingCartPage selectState(String state){
        $("select[name='region_id']").selectOptionContainingText(state);
        return this;
    }
    public ShoppingCartPage setZipCode(String zipCode){
        $("input[name='postcode']").setValue(zipCode);
        return this;
    }
    public SelenideElement deliveryMethod(){
        return $(".items.methods .label");
    }

}
