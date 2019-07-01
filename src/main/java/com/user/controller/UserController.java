package com.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.entity.UserEntity;
import com.user.service.UserService;

/**
 * @author skodi
 *
 */
@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200" )
//@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {

	/*@GetMapping(value = "/hello")
	public String hello(){
		return "Hello world..!!";
	}*/
	
	@Autowired
	private UserService userService;
	
  //@RequestMapping(value = "/saveUser", method = RequestMethod.POST) //We can write this way also.
	@PostMapping(value = "/saveUser")
	public ResponseEntity<?> saveUser(@RequestBody UserEntity userEntity){
		
		if(userEntity.getId() == 1){
			return new ResponseEntity<String>("user already Exists..", HttpStatus.CONFLICT);
		}
		userService.saveUser(userEntity);
		return new ResponseEntity<String>("User created successfully..!! ",	HttpStatus.CREATED);
	}
	
	
	@PutMapping(value = "/updateUser/{id}")
	public ResponseEntity<?> updateUser(@PathVariable("id") long id, @RequestBody UserEntity userEntity){
		userEntity.setId(id);
		userService.updateUser(userEntity);
		List<UserEntity> userList = userService.getAllUsers();
		return new ResponseEntity<List<UserEntity>>(userList, HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/getUserById/{id}")
  //@GetMapping(path = {"/getUserById/{id}"}) ////We can write this way also.
	public ResponseEntity<UserEntity> getUser(@PathVariable("id") long id){
		UserEntity user = userService.getUserById(id);
		return new ResponseEntity<UserEntity>(user, HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/getUserList")
	public ResponseEntity<List<UserEntity>> getAllUsers(){
		List<UserEntity> userList = userService.getAllUsers();
		return new ResponseEntity<List<UserEntity>>(userList, HttpStatus.OK);
	}
	
	
	@DeleteMapping(value = "/deleteUser/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable("id") long id){
		userService.deleteUser(id);
		return new ResponseEntity<String>("user deleted..!! ", HttpStatus.OK);
	}
	
	
	
	
	/*
	 * Custom Query methods
	 */
	@GetMapping(value = "/getCustomUser/{id}")
	public ResponseEntity<UserEntity> getCustomUser(@PathVariable("id") long id){
		UserEntity customUser = userService.getCustomUser(id);
		return new ResponseEntity<UserEntity>(customUser, HttpStatus.OK);
	}
	
}
