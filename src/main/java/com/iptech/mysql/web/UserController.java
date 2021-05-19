package com.iptech.mysql.web;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.iptech.mysql.domain.User;
import com.iptech.mysql.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/register")
	public String getCreateUser(ModelMap model) {
		model.put("user", new User());
		return "register";
	}
	
	@PostMapping("/register")
	public String postCreateUser(User user) {
		System.out.println(user);
		userService.save(user);
		return "redirect:/register";
	}
	
	@GetMapping("/users")
	public String getAllUsers(ModelMap model) {
		List<User> users = userService.findAll();
		model.put("users", users);
		return "users";
	}
	
	@GetMapping("/users/{userId}")
	public String findUserById(ModelMap model, @PathVariable Long userId) {
		User user = userService.findById(userId);
		model.put("users", Arrays.asList(user));
		model.put("user", user);
		return "users";
	}
	
	@PostMapping("/users/{userId}")
	public String saveUser(User user) {
		userService.save(user);
		return "redirect:/users/"+user.getUserId();
	}
	
	@PostMapping("/users/{userId}/delete")
	public String deleteUser(@PathVariable Long userId) {
		userService.delete(userId);
		return "redirect:/users/";
	}
}
