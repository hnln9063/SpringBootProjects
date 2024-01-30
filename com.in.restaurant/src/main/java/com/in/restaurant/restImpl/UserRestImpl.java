package com.in.restaurant.restImpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.in.restaurant.constants.RestaurantConstants;
import com.in.restaurant.rest.UserRest;
import com.in.restaurant.service.UserService;
import com.in.restaurant.utils.RestaurantUtils;

@RestController
public class UserRestImpl implements UserRest {
	
	@Autowired
	UserService userService;
	
	@Override
	public ResponseEntity<String> signup(Map<String, String> requestMap) {
		try {
			return userService.signup(requestMap);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return RestaurantUtils.getResponseEntity(RestaurantConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
