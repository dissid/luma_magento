package com.smarterspecies.magento2.api.payloads.addressPayLoad;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.annotation.Generated;
@Setter
@Getter
@Accessors(fluent = true)
@Generated("com.robohorse.robopojogenerator")
public class AddressesItem{

	@JsonProperty("firstname")
	private String firstname;

	@JsonProperty("city")
	private String city;

	@JsonProperty("street")
	private List<String> street;

	@JsonProperty("region_id")
	private int regionId;

	@JsonProperty("postcode")
	private String postcode;

	@JsonProperty("telephone")
	private String telephone;

	@JsonProperty("customer_id")
	private int customerId;

	@JsonProperty("region")
	private Region region;

	@JsonProperty("country_id")
	private String countryId;

	@JsonProperty("lastname")
	private String lastname;

	@JsonProperty("default_billing")
	private boolean defaultBilling;

	@JsonProperty("default_shipping")
	private boolean defaultShipping;

	@Override
 	public String toString(){
		return 
			"AddressesItem{" + 
			"firstname = '" + firstname + '\'' + 
			",city = '" + city + '\'' + 
			",street = '" + street + '\'' + 
			",region_id = '" + regionId + '\'' + 
			",postcode = '" + postcode + '\'' + 
			",telephone = '" + telephone + '\'' + 
			",customer_id = '" + customerId + '\'' + 
			",region = '" + region + '\'' + 
			",country_id = '" + countryId + '\'' + 
			",lastname = '" + lastname + '\'' + 
			",default_billing = '" + defaultBilling + '\'' + 
			",default_shipping = '" + defaultShipping + '\'' + 
			"}";
		}
}