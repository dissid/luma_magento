package com.smarterspecies.magento2.api.payloads.createOrderPayLoad;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.annotation.Generated;
import java.util.List;

@Getter
@Setter
@Accessors(fluent = true)
@Generated("com.robohorse.robopojogenerator")
public class CreateOrderPayLoad {

    @JsonProperty("paymentMethod")
    private PaymentMethod paymentMethod;

    @JsonProperty("billing_address")
    private BillingAddress billingAddress;

    @Override
    public String toString() {
        return "" + paymentMethod +
                "," + billingAddress;
    }

    public CreateOrderPayLoad setPaymentrData(String checkMoneyOrder,
                                              String randEmail,
                                              String region,
                                              int regionId,
                                              String regionCode,
                                              String countryCode,
                                              List<String> street,
                                              String postCode,
                                              String city,
                                              String firstName,
                                              String lastName,
                                              String telephone
    ) {
        return paymentMethod(
                new PaymentMethod()
                        .method(checkMoneyOrder)).
                billingAddress(
                        new BillingAddress()
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
    }
}