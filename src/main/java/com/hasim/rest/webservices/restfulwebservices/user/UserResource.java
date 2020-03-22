package com.hasim.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;
import javax.validation.Valid;
import org.apache.tomcat.util.file.ConfigurationSource.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {
	
	@Autowired
	private UserDaoService service;
	
	@GetMapping(path="/users")
	public List<User> retrieveAllUsers(){
		return service.findAll();
					
	}

	@GetMapping("/users/{id}")
	public User retrieveUser(@PathVariable int id) {
		User user =service.findOne(id);
		
		if(user==null)
			
			throw new UserNotFoundException("id-"+id);
			
			return user;
			}
	
	
	
		
	
	
	@DeleteMapping("/users/{id}")
	public void deleteuser(@PathVariable int id) {
		User user =service.deleteById(id);
		
		if(user==null)
			
			throw new UserNotFoundException("id-"+id);
			
			
	}
	
	
	// input -details user
	//output-Created and Return The created URI
	
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		
		User savedUser=service.save(user);
		
		URI location = ServletUriComponentsBuilder
		.fromCurrentRequestUri()
		.path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
		
		
	}
	
	
}
