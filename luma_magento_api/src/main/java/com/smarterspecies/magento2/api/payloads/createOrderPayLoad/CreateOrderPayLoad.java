package com.smarterspecies.magento2.api.payloads.createOrderPayLoad;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.annotation.Generated;
@Getter
@Setter
@Accessors(fluent = true)
@Generated("com.robohorse.robopojogenerator")
public class CreateOrderPayLoad{

	@JsonProperty("paymentMethod")
	private PaymentMethod paymentMethod;

	@JsonProperty("billing_address")
	private BillingAddress billingAddress;
}