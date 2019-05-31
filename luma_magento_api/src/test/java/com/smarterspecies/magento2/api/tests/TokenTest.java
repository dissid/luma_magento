package com.smarterspecies.magento2.api.tests;

import com.smarterspecies.magento2.api.Customer;
import com.smarterspecies.magento2.api.UserPayLoad;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;

public class TokenTest {

    private final UserPayLoad userPayLoad = new UserPayLoad();
    private final Customer customer = new Customer();

    @Test
    public void testCanCreateNewAccount() {
        userPayLoad.email("postman_" + randomAlphanumeric(2) + "@gorillagroup.com")
                .firstname("Test")
                .lastname("Postman")
                .websiteId(1)
                .groupId(1);
        customer.customer(userPayLoad).password("Q1w2e3r4");

        RestAssured
                .given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .filters(new RequestLoggingFilter(), new ResponseLoggingFilter())


                .when()
                .body(customer)
                .post("https://magento2.smarterspecies.com/rest/V1/customers")

                .then()
                .statusCode(200);
    }
}
