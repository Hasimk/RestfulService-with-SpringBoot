package com.hasim.rest.webservices.restfulwebservices.helloworld;

public class HellowolrdBean {

	private String message;

	public HellowolrdBean(String message) {
		
		this.message = message;
		
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "HellowolrdBean [message=" + message + "]";
	}

}
