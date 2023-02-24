package com.project.userinfo.exception;




import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class GenricRes<T> {
	
	private String messgae;
	private T data;
	private HttpStatus status;
	
}
