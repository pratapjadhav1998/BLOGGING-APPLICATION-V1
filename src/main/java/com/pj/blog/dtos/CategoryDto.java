package com.pj.blog.dtos;

import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="categories")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {
	
	private Integer categoryId;
	@NotEmpty
	@Size(min=5, message="must 4 minimum")
	private String categoryTitle;
	@NotEmpty
	@Size(min=10, message="must 10 minimum")
	private String categoryDescription;
	

}
