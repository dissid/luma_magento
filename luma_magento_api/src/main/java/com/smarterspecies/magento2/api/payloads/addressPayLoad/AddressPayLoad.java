package com.smarterspecies.magento2.api.payloads.addressPayLoad;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.annotation.Generated;
import java.util.List;
@Setter
@Getter
@Accessors(fluent = true)
@Generated("com.robohorse.robopojogenerator")
public class AddressPayLoad {

    @JsonProperty("addressCustomer")
    private AddressCustomer addressCustomer;

    @Override
    public String toString() {
        return
                "AddressPayLoad{" +
                        "addressCustomer = '" + addressCustomer + '\'' +
                        "}";
    }
    public void setUserAndAddressData(int userId,
                                      int groupId,
                                      String email,
                                      String firstName,
                                      String LastName,
                                      int storeId,
                                      int websiteId,
                                      List<AddressesItem> addressesItems
                                                ){
        return ;
    }
}