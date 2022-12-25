package com.example.rest.webservices.restfulwebservices.users;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Component;

import com.example.rest.webservices.restfulwebservices.exception.PostNotFoundException;
import com.example.rest.webservices.restfulwebservices.exception.UserNotFoundException;

@Component
public class UserDaoService {

	public static List<User> users= new ArrayList<User>();
	public static int count=3;
	
	public UserDaoService(){
		
		List <Post>ar1=new ArrayList<Post>();
		ar1.add(new Post(1,"post1"));
		ar1.add(new Post(2,"post2"));
		
		List <Post>ar2=new ArrayList<Post>();
		ar2.add(new Post(1,"post3"));
		ar2.add(new Post(2,"post4"));
		
		
		List <Post>ar3=new ArrayList<Post>();
		ar3.add(new Post(1,"post5"));
		ar3.add(new Post(2,"post6"));
		
		User u1 = new User(1,"Kalp",new Date(),ar1);
		User u2 = new User(2,"Aakash",new Date(),ar2);
		User u3 = new User(3,"Hemil", new Date(),ar3);
		
		save(u1);
		save(u2);
		save(u3);
	}
	
	public List<User> findAll() {
		return users;
	}
	
	public User save(User user) {
		if(user.getId() == 0) {
			user.setId(++count);
		}
		users.add(user);
		return user;
	}
	
	public User findOne(Integer id) {
		for(User user: users) {
			if(user.getId()== id) {
				return user;
			}
		}
		return null;
	}
	
	public List<Post> getAllPostsOfUserWithId(Integer id) {
		for(User user: users) {
			if(user.getId()== id) {
				return user.getPosts();
			}
		}
		return null;
	}
	
	public User saveNewPost(int uId, List<Post> posts) {
		User user = findOne(uId);
		
		if(user==null) {
			throw new UserNotFoundException("User with id: "+uId+" not available");
		}
		
		for(Post post: posts) {
			if(post==null || post.getPostId()==0 || post.getMessage()==null) {
				throw new PostNotFoundException("Post is invalid");
			}
			user.addPost(post);	
		}
		
		return user;
	}
}
