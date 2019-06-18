package com.smarterspecies.magento2.api.tests;

import com.smarterspecies.magento2.api.payloads.addItemsToCartPayload.AddItemsToCartPayLoad;
import com.smarterspecies.magento2.api.payloads.addItemsToCartPayload.CartItem;
import com.smarterspecies.magento2.api.payloads.createOrderPayLoad.BillingAddress;
import com.smarterspecies.magento2.api.payloads.createOrderPayLoad.CreateOrderPayLoad;
import com.smarterspecies.magento2.api.payloads.createOrderPayLoad.PaymentMethod;
import com.smarterspecies.magento2.api.payloads.prepareCheckoutPayLoad.AddressInformation;
import com.smarterspecies.magento2.api.payloads.prepareCheckoutPayLoad.PrepareCheckoutPayLoad;
import com.smarterspecies.magento2.api.payloads.prepareCheckoutPayLoad.ShippingAddress;
import com.smarterspecies.magento2.api.payloads.tokenPayLoad.TokenPayLoad;
import com.smarterspecies.magento2.api.payloads.userPayLoad.Customer;
import com.smarterspecies.magento2.api.payloads.userPayLoad.UserPayLoad;
import com.smarterspecies.magento2.api.services.*;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.*;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;

public class CreateOrderTest extends BaseTest {

    private final UserPayLoad userPayLoad = new UserPayLoad();
    private final Customer customer = new Customer();
    private final UserApiService userApiService = new UserApiService();
    private final TokenApiService tokenApiService = new TokenApiService();
    private final TokenPayLoad tokenPayLoad = new TokenPayLoad();
    private final QuoteApiService quoteApiService = new QuoteApiService();
    private final AddItemsToCartPayLoad addItemsToCartPayLoad = new AddItemsToCartPayLoad();
    private final CartItem cartItem = new CartItem();
    private final AddItemsToCartApiService addItemsToCartApiService = new AddItemsToCartApiService();
    private final CreateOrderPayLoad createOrderPayLoad = new CreateOrderPayLoad();
    private final BillingAddress billingAddress = new BillingAddress();
    private final PaymentMethod paymentMethod = new PaymentMethod();
    private final CreateOrderApiService createOrderApiService = new CreateOrderApiService();
    private final PrepareCheckoutPayLoad prepareCheckoutPayLoad = new PrepareCheckoutPayLoad();
    private final ShippingAddress shippingAddress = new ShippingAddress();
    private final AddressInformation addressInformation = new AddressInformation();
    private final PrepareCheckoutApiService prepareCheckoutApiService = new PrepareCheckoutApiService();

    @Test
    public void testCanPlaceOrder() {
        //given
        //User Information
        String randEmail = "automation_" + randomAlphanumeric(2) + "@gorillagroup.com";
        String firstName = "Automation";
        String lastName = "Test";
        String password = "Q1w2e3r4";
        String productSku = "24-WB04";

        // Address information
        String region = "New York";
        int regionId = 43;
        String regionCode = "NY";
        String countryCode = "US";
        List<String> street = singletonList("123 Oak Ave");
        String postCode = "10577";
        String city = "Purchase";
        String telephone = "512-555-1111";
        String shippingMethod = "flatrate";
        String checkMoneyOrder = "checkmo";

        //initialization user data
        customer
                .customer(userPayLoad
                        .email(randEmail)
                        .firstname(firstName)
                        .lastname(lastName)
                        .websiteId(1)
                        .groupId(1))
                .password(password);

        //initialization user data for getting token
        tokenPayLoad.username(randEmail).password(password);

        //initialization shipping information
        prepareCheckoutPayLoad
                .addressInformation(addressInformation
                        .shippingAddress(shippingAddress
                                .region(region)
                                .regionId(regionId)
                                .regionCode(regionCode)
                                .countryId(countryCode)
                                .street(street)
                                .postcode(postCode)
                                .city(city)
                                .firstname(firstName)
                                .lastname(lastName)
                                .email(randEmail)
                                .telephone(telephone))
                        .shippingCarrierCode(shippingMethod)
                        .shippingMethodCode(shippingMethod));

        //initialization billing and payment information
        createOrderPayLoad
                .paymentMethod(paymentMethod
                        .method(checkMoneyOrder))
                .billingAddress(billingAddress
                        .email(randEmail)
                        .region(region)
                        .regionId(regionId)
                        .regionCode(regionCode)
                        .countryId(countryCode)
                        .street(street)
                        .postcode(postCode)
                        .city(city)
                        .telephone(telephone)
                        .firstname(firstName)
                        .lastname(lastName));

        //when
        userApiService.registerNewUser(customer);
        String token = tokenApiService.getToken(tokenPayLoad);
        String quoteId = quoteApiService.getQuoteId(token);
        addItemsToCartPayLoad.
                cartItem(cartItem
                        .sku(productSku)
                        .qty(1)
                        .quoteId(quoteId));
        addItemsToCartApiService
                .addingProductToCart(addItemsToCartPayLoad, token);
        prepareCheckoutApiService.setShippingInformation(token, prepareCheckoutPayLoad);

        //then
        createOrderApiService.placeOrder(token, createOrderPayLoad)
                .then()
                .assertThat().statusCode(200)
                .and()
                .body(Matchers.not(Matchers.isEmptyString()));

    }
}
