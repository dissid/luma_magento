package com.smarterspecies.magento2.api.payloads.addressPayLoad;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.annotation.Generated;
@Setter
@Getter
@Accessors(fluent = true)
@Generated("com.robohorse.robopojogenerator")
public class Region{

	@JsonProperty("region_id")
	private int regionId;

	@JsonProperty("region")
	private String region;

	@JsonProperty("region_code")
	private String regionCode;

	@Override
 	public String toString(){
		return 
			"Region{" + 
			"region_id = '" + regionId + '\'' + 
			",region = '" + region + '\'' + 
			",region_code = '" + regionCode + '\'' + 
			"}";
		}
}