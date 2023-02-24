package com.project.userinfo.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {

	 private int statusCode;
	 private String message;
	 private LocalDateTime timestamp;
}
