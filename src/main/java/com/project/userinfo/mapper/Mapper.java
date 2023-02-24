package com.project.userinfo.mapper;

import org.springframework.beans.BeanUtils;

import com.project.userinfo.domain.AddressDomain;
import com.project.userinfo.domain.UserDomain;
import com.project.userinfo.model.AddressModel;
import com.project.userinfo.model.UserModel;

public class Mapper {
	
	public static UserModel domainToModel(UserDomain userDomain) {
		UserModel userModel = new UserModel();
	    AddressModel addressModel = new AddressModel();
		BeanUtils.copyProperties(userDomain, userModel);
		BeanUtils.copyProperties(userDomain.getAddressDomain(), addressModel);
		userModel.setAddressModel(addressModel);
		return userModel;
	}
	
	public static UserDomain modelToDomain(UserModel userModel) {
		UserDomain userDomain = new UserDomain();
		AddressDomain addressDomain = new AddressDomain();
		BeanUtils.copyProperties(userModel, userDomain);
		BeanUtils.copyProperties(userModel.getAddressModel(), addressDomain);
		userDomain.setAddressDomain(addressDomain);
		return userDomain;
		
	}

}
