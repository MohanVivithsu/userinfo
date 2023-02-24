package com.project.userinfo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.userinfo.domain.UserDomain;
import com.project.userinfo.exception.UserNotFoundException;
import com.project.userinfo.mapper.Mapper;

import com.project.userinfo.model.UserModel;
import com.project.userinfo.repository.UserRepository;

@Transactional
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public String saveUser(UserModel userModel) throws Exception {
		UserDomain userDomain = Mapper.modelToDomain(userModel);
		userRepository.save(userDomain);
		log.info("User Details  Saved Successfully ");
		return "User Details Saved";
	}

	@Override
	public List<UserModel> getAllUsers() throws Exception {
		log.info("All Users Details fetching...");
		List<UserDomain> userDomainList = userRepository.findByStatus(true);
		log.info("All Users Details fetched Successfully");
		List<UserModel> userModelList = new ArrayList<>();
		userModelList = userDomainList.stream().map(userDoamin -> Mapper.domainToModel(userDoamin))
				.collect(Collectors.toList());
		return userModelList;
	}

	@Override
	public String updateUser(UserModel userModel, String userId) throws Exception {

		UserDomain userDomain = null;
		log.info("User Details fetching...");
		try {
			userDomain = userRepository.findByUserId(userId);
		} catch (Exception e) {
			throw new UserNotFoundException("No User found with this userId :" + userId);
		}
		log.info("User Details fetched Successfully");
		if (userModel.getUserName() != null)
			userDomain.setUserName(userModel.getUserName());
		if (userModel.getUserEmail() != null)
			userDomain.setUserEmail(userModel.getUserEmail());
		if (userModel.getAddressModel().getDoorNumber() != null)
			userDomain.getAddressDomain().setDoorNumber(userModel.getAddressModel().getDoorNumber());
		if (userModel.getAddressModel().getStreet() != null)
			userDomain.getAddressDomain().setStreet(userModel.getAddressModel().getStreet());
		if (userModel.getAddressModel().getDistrict() != null)
			userDomain.getAddressDomain().setDistrict(userModel.getAddressModel().getDistrict());
		if (userModel.getAddressModel().getState() != null)
			userDomain.getAddressDomain().setState(userModel.getAddressModel().getState());
		if (userModel.getAddressModel().getPincode() != null)
			userDomain.getAddressDomain().setPincode(userModel.getAddressModel().getPincode());

		userRepository.save(userDomain);
		log.info("User Details updated Successfully");
		return "User Details updated";
	}

	@Override
	public String deleteUser(String userId) throws Exception {
		UserDomain userDomain = userRepository.findByUserId(userId);
		userDomain.setStatus(false);
		userRepository.save(userDomain);
		log.info("User Details deleted Successfully :", userId);
		return "User Deleted ";
	}

	@Override
	public UserModel getUserByUserId(String userId) throws Exception {
		log.info("User Details fetching...");
		try {
			UserDomain userDomain = userRepository.findByUserIdAndStatus(userId, true);
			log.info("User Details  fetched Successfully");
			return Mapper.domainToModel(userDomain);
		} catch (Exception e) {
			throw new UserNotFoundException("No User found with this userId :" + userId);
		}

	}

}
