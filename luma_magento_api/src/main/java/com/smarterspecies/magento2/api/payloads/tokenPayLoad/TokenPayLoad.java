package com.smarterspecies.magento2.api.payloads.tokenPayLoad;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.annotation.Generated;

@Setter
@Getter
@Accessors(fluent = true)
@Generated("com.robohorse.robopojogenerator")
public class TokenPayLoad {

    @JsonProperty("password")
    private String password;

    @JsonProperty("username")
    private String username;

    @Override
    public String toString() {
        return  "password='" + password + '\'' +
                ", username='" + username + '\'';
    }
}