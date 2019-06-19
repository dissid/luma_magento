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
import com.smarterspecies.magento2.api.services.*;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.util.List;

import static java.util.Collections.*;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;

public class CreateOrderTest extends BaseTest {

    private final Customer customer = new Customer();
    private final UserApiService userApiService = new UserApiService();
    private final TokenApiService tokenApiService = new TokenApiService();
    private final TokenPayLoad tokenPayLoad = new TokenPayLoad();
    private final QuoteApiService quoteApiService = new QuoteApiService();
    private final AddItemsToCartPayLoad addItemsToCartPayLoad = new AddItemsToCartPayLoad();
    private final AddItemsToCartApiService addItemsToCartApiService = new AddItemsToCartApiService();
    private final CreateOrderPayLoad createOrderPayLoad = new CreateOrderPayLoad();
    private final CreateOrderApiService createOrderApiService = new CreateOrderApiService();
    private final PrepareCheckoutPayLoad prepareCheckoutPayLoad = new PrepareCheckoutPayLoad();
    private final PrepareCheckoutApiService prepareCheckoutApiService = new PrepareCheckoutApiService();

    @Test
    public void testCanPlaceOrder() {
        //given
        String productSku = "24-WB04";
        int qty = 1;


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
        String shippingCarrierCode = "flatrate";
        String paymentSystem = "checkmo";

        //initialization user data
        customer.setNewCustomerData(RAND_EMAIL, FIRST_NAME, LAST_NAME, WEBSITE_ID, GROUP_ID, PASSWORD);

        //initialization user data for getting token
        tokenPayLoad.username(RAND_EMAIL).password(PASSWORD);


        //initialization shipping information
        prepareCheckoutPayLoad.setCheckoutData(region,
                regionId,
                regionCode,
                countryCode,
                street,
                postCode,
                city,
                FIRST_NAME,
                LAST_NAME,
                RAND_EMAIL,
                telephone,
                shippingMethod,
                shippingCarrierCode);


        //initialization billing and payment information
        createOrderPayLoad.setPaymentrData(paymentSystem,
                RAND_EMAIL,
                region,
                regionId,
                regionCode,
                countryCode,
                street,
                postCode,
                city,
                FIRST_NAME,
                LAST_NAME,
                telephone);


        //when
        userApiService.registerNewUser(customer);
        String token = tokenApiService.getUserToken(tokenPayLoad);
        String quoteId = quoteApiService.getQuoteId(token);
        addItemsToCartPayLoad.setProductToCart(productSku, qty, quoteId);
        addItemsToCartApiService.addingProductToCart(addItemsToCartPayLoad, token);
        prepareCheckoutApiService.setShippingInformation(token, prepareCheckoutPayLoad);

        //then
        createOrderApiService.placeOrder(token, createOrderPayLoad)
                .then()
                .assertThat().statusCode(200)
                .and()
                .body(Matchers.not(Matchers.isEmptyString()));

    }
}
