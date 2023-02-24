package com.project.userinfo.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.project.userinfo.exception.GenricRes;
import com.project.userinfo.exception.HttpResponse;
import com.project.userinfo.model.UserModel;
import com.project.userinfo.service.UserService;

@RestController
@SuppressWarnings("rawtypes")
public class UserController {

	@Autowired
	UserService userService;

	Logger log = LoggerFactory.getLogger(UserController.class);

	@PostMapping(value = "/save/user")
	public ResponseEntity<GenricRes> saveUser(@Valid @RequestBody UserModel userModel) throws Exception {
		log.debug("Request: saveUser {}", userModel);
		String response = userService.saveUser(userModel);
		log.debug("Response: saveUser {}", response);
		return HttpResponse.prepareResponse(response);
	}

	@GetMapping(value = "/get/allUsers")
	public ResponseEntity<GenricRes> getAllUsers() throws Exception {
		log.debug("Request: getAllUsers ");
		List<UserModel> response = userService.getAllUsers();
		return HttpResponse.prepareResponse(response);
	}

	@GetMapping(value = "/get/user/{userId}")
	public ResponseEntity<GenricRes> getUserByUserId(@PathVariable("userId") String userId) throws Exception {
		log.debug("Request: getUserByUserId {}", userId);
		UserModel response = userService.getUserByUserId(userId);
		log.debug("Response: getUserByUserId {} ", response);
		return HttpResponse.prepareResponse(response);
	}

	@PutMapping(value = "/update/user/{userId}")
	public ResponseEntity<GenricRes> updateUser(@PathVariable("userId") String userId,
			@Valid @RequestBody UserModel userModel) throws Exception {
		log.debug("Request: updateUser {}", userId);
		log.debug("Request: RequestBody {}", userModel);
		String response = userService.updateUser(userModel, userId);
		log.debug("Response: updateUser {} ", response);
		return HttpResponse.prepareResponse(response);
	}

	@DeleteMapping(value = "/delete/user/{userId}")
	public ResponseEntity<GenricRes> deleteUserByUserId(@PathVariable("userId") String userId) throws Exception {
		log.debug("Request: deleteUserByUserId {}", userId);
		String response = userService.deleteUser(userId);
		log.debug("Response: deleteUserByUserId {}", response);
		return HttpResponse.prepareResponse(response);
	}

}
