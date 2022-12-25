package com.example.rest.webservices.restfulwebservices.users;

public class Post{

	private int postId;
	private String message;
	
	public Post(int postId, String msg) {
		this.setMessage(msg);
		this.setPostId(postId);
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
	public String toString() {
		return "Post [postId=" + getPostId() + ", message=" + getMessage() + "]";
	}
}
