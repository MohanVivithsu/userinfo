package com.project.userinfo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SuppressWarnings("rawtypes")
public class HttpResponse {

	final static String messgae = "SUCCESS";
	final static HttpStatus status = HttpStatus.OK;

	public static <T> ResponseEntity<GenricRes> prepareResponse(T data) {
		GenricRes<T> response = new GenricRes<T>();
		response.setData(data);
		response.setMessgae(messgae);
		response.setStatus(status);
		return new ResponseEntity<GenricRes>(response,status);
	}
}
