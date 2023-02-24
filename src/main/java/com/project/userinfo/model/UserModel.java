package com.project.userinfo.model;

import java.io.Serializable;

import java.time.LocalDateTime;


import javax.validation.Valid;
import javax.validation.constraints.Email;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3082227501855700880L;
	private String userId;
	@Size(max = 15, message = "Username must be less than 15 characters ")
	private String userName;
	@Email(message = "Email address is not valid !! Please Enter Valid Email address")
	@NotBlank
	private String userEmail;
	private LocalDateTime userRegistrationDate;
	@Valid
	private AddressModel addressModel;
	private boolean status;
	


}
