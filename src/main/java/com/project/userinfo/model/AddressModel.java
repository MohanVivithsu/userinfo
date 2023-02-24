package com.project.userinfo.model;

import java.io.Serializable;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5646754843608523891L;

	private String addressId;
	@NotNull
	@NotBlank
	private String doorNumber;
	private String street;
	private String district;
	@NotBlank
	@NotNull
	private String state;
	@NotNull
	@NotBlank
	private String pincode;

}
