package com.smarterspecies.magento2.api.payloads.createOrderPayLoad;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.annotation.Generated;
@Setter
@Getter
@Accessors(fluent = true)
@Generated("com.robohorse.robopojogenerator")
public class PaymentMethod{

	@JsonProperty("method")
	private String method;

	@Override
	public String toString() {
		return "method='" + method + '\'';
	}
}