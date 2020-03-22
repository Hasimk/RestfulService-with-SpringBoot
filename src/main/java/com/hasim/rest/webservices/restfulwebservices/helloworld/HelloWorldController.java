package com.hasim.rest.webservices.restfulwebservices.helloworld;
import java.util.Locale;

import org.apache.tomcat.util.http.parser.AcceptLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	// method -"Hello World"
	//GET
	//URI- /hello-world
	
	@Autowired
	private MessageSource messageSource;
	
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
	
	@GetMapping(path="/hello-world-internationalized")
	public String helloworldInternationalized(@RequestHeader(name = "Accept-Language", required = false) Locale locale) {
		return messageSource.getMessage("good.morning.message",null, locale);
		
		
	}
}
