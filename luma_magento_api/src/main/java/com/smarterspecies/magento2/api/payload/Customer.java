
package com.smarterspecies.magento2.api.payload;

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


}