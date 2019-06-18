package com.smarterspecies.magento2.api.payloads.prepareCheckoutPayLoad;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.annotation.Generated;
@Getter
@Setter
@Accessors(fluent = true)
@Generated("com.robohorse.robopojogenerator")
public class ShippingAddress{

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

	@JsonProperty("region")
	private String region;

	@JsonProperty("country_id")
	private String countryId;

	@JsonProperty("email")
	private String email;

	@JsonProperty("region_code")
	private String regionCode;

	@JsonProperty("lastname")
	private String lastname;

	@Override
	public String toString() {
		return "firstname='" + firstname + '\'' +
				", city='" + city + '\'' +
				", street=" + street +
				", regionId=" + regionId +
				", postcode='" + postcode + '\'' +
				", telephone='" + telephone + '\'' +
				", region='" + region + '\'' +
				", countryId='" + countryId + '\'' +
				", email='" + email + '\'' +
				", regionCode='" + regionCode + '\'' +
				", lastname='" + lastname + '\'';
	}
}