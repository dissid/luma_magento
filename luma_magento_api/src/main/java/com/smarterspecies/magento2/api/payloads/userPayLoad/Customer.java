
package com.smarterspecies.magento2.api.payloads.userPayLoad;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.smarterspecies.magento2.api.payloads.userPayLoad.UserPayLoad;
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
		return "Customer{" +
				"password='" + password + '\'' +
				", customer=" + customer +
				'}';
	}
}