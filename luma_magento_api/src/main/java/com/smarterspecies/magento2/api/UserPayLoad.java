package com.smarterspecies.magento2.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.annotation.Generated;

@Getter
@Setter
@Accessors(fluent = true)
@Generated("com.robohorse.robopojogenerator")
public class UserPayLoad {


    @JsonProperty("firstname")
    private String firstname;

    @JsonProperty("group_id")
    private int groupId;

    @JsonProperty("website_id")
    private int websiteId;

    @JsonProperty("email")
    private String email;

    @JsonProperty("lastname")
    private String lastname;


}