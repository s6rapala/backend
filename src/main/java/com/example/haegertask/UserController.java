package com.example.haegertask;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/users")
	private List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@GetMapping("/user/{id}")
	private User getUser(@PathVariable("id") int id) {
		return userService.getUserById(id);
	}
	
	@DeleteMapping("/users/{id}")
	private void deleteUser(@PathVariable("id") int id) {
		userService.delete(id);
	}
	
	@PostMapping("/users")
	private int saveUser(@RequestBody User user) {
		userService.saveOrUpdate(user);
		return user.getId();
	}
}
