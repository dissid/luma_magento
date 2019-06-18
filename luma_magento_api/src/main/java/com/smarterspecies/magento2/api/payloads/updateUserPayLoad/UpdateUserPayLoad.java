package com.smarterspecies.magento2.api.payloads.updateUserPayLoad;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.annotation.Generated;

@Getter
@Setter
@Accessors(fluent = true)
@Generated("com.robohorse.robopojogenerator")
public class UpdateUserPayLoad{

	@JsonProperty("customer")
	private CustomerData customer;

	@Override
	public String toString() {
		return 	"" + customer;
	}
}