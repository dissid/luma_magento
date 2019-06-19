
package com.smarterspecies.magento2.api.payloads.userPayLoad;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.annotation.Generated;

@Getter
@Setter
@Accessors(fluent = true)
@Generated("com.robohorse.robopojogenerator")
public class Customer {

    @JsonProperty("password")
    private String password;

    @JsonProperty("customer")
    private UserPayLoad customer;

    @Override
    public String toString() {
        return "password='" + password + '\'' +
                "," + customer;
    }

    public Customer setNewCustomerData(String email,
                                       String fistrName,
                                       String lastName,
                                       int websiteId,
                                       int groupId,
                                       String password) {
        return customer(
                new UserPayLoad()
                        .email(email)
                        .firstname(fistrName)
                        .lastname(lastName)
                        .websiteId(websiteId)
                        .groupId(groupId))
                .password(password);


    }
}