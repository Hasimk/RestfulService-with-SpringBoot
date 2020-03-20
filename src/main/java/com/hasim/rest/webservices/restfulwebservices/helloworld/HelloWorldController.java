package com.hasim.rest.webservices.restfulwebservices.helloworld;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	// method -"Hello World"
	//GET
	//URI- /hello-world
	
	@GetMapping(path="/hello-world")
	public String helloWorld()
	{
		return "Hello World";
		
	}
	
	// hello-world-bean
	@GetMapping(path="/hello-world-bean")
	public HellowolrdBean helloWorldBean()
	{
		return new HellowolrdBean ("Hello World bean");
		
	}
	
	@GetMapping(path="/hello-world/path-variable/{name}")
	public HellowolrdBean helloWorldPathVariable(@PathVariable String name)
	{
		return new HellowolrdBean (String.format("Hello World, %s", name));
		
	}
	
}
