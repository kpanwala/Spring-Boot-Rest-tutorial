package com.example.rest.webservices.restfulwebservices.users;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public class User {

	private int id;
	
	@Size(min=2,message="Name should have atleast 2 chars")
	private String name;
	
	@Past
	private Date birthDate;
	private List<Post> posts;
	
	public int getId() {
		return id;
	}
	public List<Post> getPosts() {
		return posts;
	}
	
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	
	public void addPost(Post post) {
		this.posts.add(post);
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
	}
	
	public User() {
		
	}
	
	public User(int id, String name, Date date) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = date;
		this.posts = new ArrayList<Post>();
	}
	
	public User(int id, String name, Date date, List<Post> posts) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = date;
		this.posts=posts;
	}
}
