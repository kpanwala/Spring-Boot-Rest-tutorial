package com.example.rest.webservices.restfulwebservices.users;
import java.util.List;

public class UserWithPostForPost {
	int id;
	List<Post> post;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Post> getPost() {
		return post;
	}

	public void setPost(List<Post> post) {
		this.post = post;
	}

	@Override
	public String toString() {
		return "UserWithPostForPost [id=" + id + ", post=" + post + "]";
	}

	public UserWithPostForPost getDataForPostFromUser(User user) {
		return new UserWithPostForPost(user.getId(),user.getPosts());
	}

	public UserWithPostForPost(int id, List<Post> post) {
		super();
		this.setId(id);
		this.setPost(post);
	}
}
