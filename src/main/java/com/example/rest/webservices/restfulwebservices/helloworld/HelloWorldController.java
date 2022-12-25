package com.example.rest.webservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@RequestMapping(method=RequestMethod.GET, path="hello-world")
	public String helloWorld() {
		return "hello world";
	}
	
	@GetMapping(path="hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("hello world");
	}
	
	@GetMapping(path="hello-world-version", headers="X-API-Version=1")
	public HelloWorldBean helloWorldBeanVersion1() {
		return new HelloWorldBean("hello world 1");
	}
	
	@GetMapping(path="hello-world-version", headers="X-API-Version=2")
	public HelloWorldBean helloWorldBeanVersion2() {
		return new HelloWorldBean("hello world 2");
	}
	
	@GetMapping(path="hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("hello %s",name));
	}
}
