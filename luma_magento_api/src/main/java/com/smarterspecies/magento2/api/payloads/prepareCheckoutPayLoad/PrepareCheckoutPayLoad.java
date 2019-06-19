package com.smarterspecies.magento2.api.payloads.prepareCheckoutPayLoad;

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
public class PrepareCheckoutPayLoad {

    @JsonProperty("addressInformation")
    private AddressInformation addressInformation;

    @Override
    public String toString() {
        return "" + addressInformation;
    }

    public PrepareCheckoutPayLoad setCheckoutData(String region,
                                                  int regionId,
                                                  String regionCode,
                                                  String countryCode,
                                                  List<String> street,
                                                  String postCode,
                                                  String city,
                                                  String firstName,
                                                  String lastName,
                                                  String randEmail,
                                                  String telephone,
                                                  String shippingMethod,
                                                  String shippingCarrierCode
                                                  ) {
        return addressInformation(new AddressInformation().shippingAddress(
                new ShippingAddress()
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
                .shippingMethodCode(shippingCarrierCode));
    }
}