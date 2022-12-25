package com.example.rest.webservices.restfulwebservices.users;

import java.net.URI;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.rest.webservices.restfulwebservices.exception.UserNotFoundException;

import jakarta.validation.Valid;

@RestController
public class UserResource {

	// creating a logger
	//private Logger logger = LoggerFactory.getLogger(UserResource.class);
    
	@Autowired
	private UserDaoService service;
	
	@GetMapping("/users")
	public List<User> retrieveAllUsers(){
		//logger.debug("Get all users");
		return service.findAll();
	}
	
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser = service.save(user);
		/*
		 * Payload
		 *  {
			    "id": 4,
			    "name": "Kalp2",
			    "birthDate": "2022-09-22T06:10:54.714+00:00"
			}
		 * 
		 */
		
		URI location = ServletUriComponentsBuilder
			.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(savedUser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
		
	}
	
	@GetMapping("/users/{id}")
	public User retrieveAUser(@PathVariable Integer id){
		User createdUser = service.findOne(id);
		
		if (createdUser == null) throw new UserNotFoundException("User Id: "+id);
		
		return createdUser;
	}
	
	
	@GetMapping("/users/{uId}/posts")
	public List<Post> retrieveAllPostsOfUserWithId(@PathVariable Integer uId){
		List<Post> posts= service.getAllPostsOfUserWithId(uId);
		
		if (posts==null || posts.size() == 0) throw new UserNotFoundException("User Id: "+uId);
		
		return posts;
	}
	
	@PostMapping("/users/{uId}/posts")
	@ResponseStatus(HttpStatus.CREATED)
	public User createPostForUser1(@RequestBody List<Post> posts, @PathVariable Integer uId) {

		/*
		* Payload
		* [
		    {
		        "postId": 3,
		        "message": "post3"
		    }
		  ]
		 * 
		 */
		User savedUser = service.saveNewPost(uId, posts);
		
        return savedUser;
		
	}
}
