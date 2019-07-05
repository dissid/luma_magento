package com.smarterspecies.magento2.ui.tests;

import com.smarterspecies.magento2.api.payloads.addItemsToCartPayload.AddItemsToCartPayLoad;
import com.smarterspecies.magento2.api.payloads.tokenPayLoad.TokenPayLoad;
import com.smarterspecies.magento2.api.payloads.userPayLoad.Customer;
import com.smarterspecies.magento2.api.services.AddItemsToCartApiService;
import com.smarterspecies.magento2.api.services.QuoteApiService;
import com.smarterspecies.magento2.api.services.TokenApiService;
import com.smarterspecies.magento2.api.services.UserApiService;
import com.smarterspecies.magento2.common.BaseTest;
import com.smarterspecies.magento2.ui.LoginPage;
import com.smarterspecies.magento2.ui.ProductDetailsPage;
import com.smarterspecies.magento2.ui.ShoppingCartPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;

public class ShoppingCartTest extends BaseTest {

    private final Customer customer = new Customer();
    private final TokenPayLoad tokenPayLoad = new TokenPayLoad();
    private final TokenApiService tokenApiService = new TokenApiService();
    private final UserApiService userApiService = new UserApiService();
    private final QuoteApiService quoteApiService = new QuoteApiService();
    private final AddItemsToCartPayLoad addItemsToCartPayLoad = new AddItemsToCartPayLoad();
    private final AddItemsToCartApiService addItemsToCartApiService = new AddItemsToCartApiService();
    private String randEmail = "";

    @BeforeMethod
    public void createUserAndAddProductToShoppingCart() {

        randEmail = "automation_" + randomAlphanumeric(6) + "@gorillagroup.com";
        String productSku = "24-WB04";
        int productQty = 1;

        //initialization user data
        customer.setNewCustomerData(randEmail, FIRST_NAME, LAST_NAME, WEBSITE_ID, GROUP_ID, PASSWORD);

        //initialization user data for getting token
        tokenPayLoad.username(randEmail).password(PASSWORD);

        userApiService.registerNewUser(customer);

        String token = tokenApiService.getUserToken(tokenPayLoad);
        String quoteId = quoteApiService.getQuoteId(token);
        addItemsToCartPayLoad.setProductToCart(productSku, productQty, quoteId);
        addItemsToCartApiService.addingProductToCart(addItemsToCartPayLoad, token);

    }

    @Test
    public void testCanEditProductQty() {
        int productQty = 2;
        LoginPage.open().fillLoginForm(randEmail, PASSWORD);
        ShoppingCartPage
                .open()
                .updateProductQty(productQty)
                .qtyField().shouldHave(value(String.valueOf(productQty)));
    }

    @Test
    public void testCanEstimateShippingAndTax() {
        LoginPage.open().fillLoginForm(randEmail, PASSWORD);
        ShoppingCartPage
                .open()
                .openEstimateShippingAndTaxBlock()
                .selectCountry("United States")
                .selectState("Illinois")
                .setZipCode("60604")
                .deliveryMethod().shouldHave(text("Fixed $5.00"));

    }
    @Test
    public void testCanEditProduct() {
        int productQty = 3;
        LoginPage.open().fillLoginForm(randEmail, PASSWORD);
        ProductDetailsPage productDetailsPage = ShoppingCartPage
                .open()
                .editProduct();
        ShoppingCartPage shoppingCartPage = productDetailsPage
                .editProductQty(productQty);
        shoppingCartPage.qtyField().shouldHave(value(String.valueOf(productQty)));

    }
    @Test
    public void testCanRemoveProductFromShoppingCart() {
        LoginPage.open().fillLoginForm(randEmail, PASSWORD);

        ShoppingCartPage
                .open()
                .removeProduct()
                .shoppingCart()
                .shouldHave(text("You have no items in your shopping cart.\nClick here to continue shopping."));
    }

}
