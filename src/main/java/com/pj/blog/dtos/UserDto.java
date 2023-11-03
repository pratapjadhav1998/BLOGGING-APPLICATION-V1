package com.pj.blog.dtos;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@Getter
@Setter
public class UserDto {

	private int id;
	@NotEmpty
	@Size(min=4,message="user anme must be 4 character")
	private String name;
	@NotNull 
	@Email(message="email is not valid")
	private String email;
	@NotEmpty
	@Size(min=3, max=10, message="enter password min 4, max 10")
//	@Pattern(regexp)
	private String password;
	@NotEmpty
	private String about;
	
}
