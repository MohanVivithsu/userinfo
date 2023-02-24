package com.project.userinfo.service;

import java.util.List;

import com.project.userinfo.model.UserModel;

public interface UserService {

	public String saveUser(UserModel userModel) throws Exception;

	public List<UserModel> getAllUsers() throws Exception;

	public String updateUser(UserModel userModel, String userId) throws Exception;

	public String deleteUser(String userId) throws Exception;
	
	public UserModel getUserByUserId(String userId)throws Exception;

}
