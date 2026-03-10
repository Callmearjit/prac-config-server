package com.user_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.user_service.entity.UserInformation;
import com.user_service.repo.UserJpaRepository;

@Service
public class UserService {
	private UserJpaRepository jpa;
	public  UserService(UserJpaRepository jpa) {
		this.jpa=jpa;
	}
	public String createUser(UserInformation info) {
		jpa.save(info);
		return "Data Saved.";
	}

//	public String finduser(String emailId) {
//		jpa.findById(emailId).orElseThrow(()-> new RuntimeExceptions"User not found");
//	}
	
	 // Get all users
	public List<UserInformation> getAllUsers() {
	    return jpa.findAll();
	}

	public UserInformation findUserById(String emailId) {
	    return jpa.findById(emailId)
	              .orElseThrow(() -> new RuntimeException("User not found"));
	}

    // Delete user
    public String deleteUser(String emailId) {
    	jpa.deleteById(emailId);
        return "User deleted successfully";
    }

}
