package com.in.restaurant.rest;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(path="/user")
public interface UserRest {
	
	@PostMapping(path="/signup")
	// As we are accepting the values here.. so this is a post mapping
	public ResponseEntity<String> signup(@RequestBody(required = true) Map<String, String> requestMap);

}
