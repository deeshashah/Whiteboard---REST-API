package com.example.webdevsp19s1deeshashahserverjava.services;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.webdevsp19s1deeshashahserverjava.model.User;

import java.util.*;

@RestController
public class UserService {
	User alice = new User(123, "alice", "Alice", "Wonderland", "FACULTY");
	User bob   = new User(234, "bob", "Bob", "Marley", "FACULTY");
	List<User> users = new ArrayList<User>();

	UserService(){
		users.add(alice);
		users.add(bob);
	}

	@GetMapping("/api/user")
	public User[] findAllUser() {
		User[] users = new User[this.users.size()];
		return this.users.toArray(users);
	}

	@GetMapping("/api/user/{userId}")
	public User findUserById(
			@PathVariable("userId") Integer id) {
		for(User user: users) {
			if(id == user.getId().intValue())
				return user;
		}
		return null;
	}

	@PostMapping("/api/user")
	public User createUser(@RequestBody User user) {
		users.add(user);
		return user;
	}

	@DeleteMapping("/api/user/{userId}")
	public void deleteUser(
		@PathVariable("userId") Integer id) {
		for(User usr: users){
			if(id == usr.getId().intValue())
				users.remove(usr);
		}
	}

	@PutMapping("api/user/{userId}")
	public @ResponseBody User updateUser(
		@PathVariable("userId") Integer id, @RequestBody User user) {

		for(int i=0;i<users.size();i++){
			if(users.get(i).getId().intValue()==id){
				users.set(i, user);
				return user;
			}
		}

		return null;
	}
}