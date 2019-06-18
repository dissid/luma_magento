package com.smarterspecies.magento2.api.payloads.prepareCheckoutPayLoad;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.annotation.Generated;
@Getter
@Setter
@Accessors(fluent = true)
@Generated("com.robohorse.robopojogenerator")
public class PrepareCheckoutPayLoad {

	@JsonProperty("addressInformation")
	private AddressInformation addressInformation;

	@Override
	public String toString() {
		return 	"" + addressInformation;
	}
}