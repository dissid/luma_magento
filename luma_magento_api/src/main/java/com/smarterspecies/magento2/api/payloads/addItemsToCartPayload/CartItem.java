package com.smarterspecies.magento2.api.payloads.addItemsToCartPayload;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.annotation.Generated;

@Setter
@Getter
@Accessors(fluent = true)
@Generated("com.robohorse.robopojogenerator")
public class CartItem{

	@JsonProperty("qty")
	private int qty;

	@JsonProperty("quote_id")
	private String quoteId;

	@JsonProperty("sku")
	private String sku;


	@Override
	public String toString() {
		return 	"qty=" + qty +
				", quoteId='" + quoteId + '\'' +
				", sku='" + sku + '\'';
	}
}