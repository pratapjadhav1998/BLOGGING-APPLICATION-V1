package com.pj.blog.entities;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;
//import java.util.ArrayList;
import java.util.List.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="categories")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Category {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer category_Id;
	
	@Column(name="title", length=100, nullable=false)
	private String categoryTitle;
	
	@Column(name="description")
	private String categoryDescription;
	

	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	
	private List<Post> posts= new ArrayList<>();
	
	
	
}
