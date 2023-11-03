package com.pj.blog.dtos;

import lombok.Data;

@Data
public class JwtAuthRequest {

	
	private String userName;
	private String password;
	
	
}
