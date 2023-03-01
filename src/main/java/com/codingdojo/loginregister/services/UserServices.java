package com.codingdojo.loginregister.services;


import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import com.codingdojo.loginregister.model.LoginUser;
import com.codingdojo.loginregister.model.User;
import com.codingdojo.loginregister.repositories.UserRepo;


@Service
public class UserServices {
    
	   
    @Autowired
    private UserRepo userRepo;
    
    public User register(User newUser, BindingResult result) {
    	
    	Optional<User> awsomeUser = userRepo.findByEmail(newUser.getEmail());
    	
    	if(awsomeUser.isPresent()) {
    		result.rejectValue("email", "Matches", "An account with that email already exists!");
    	}

    	if(!newUser.getPassword().equals(newUser.getConfirm())) {
    	    result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");//rejectValue take
    	}

        if(result.hasErrors()) {
        	return null;
        }
//    hashing password
        String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
        newUser.setPassword(hashed);
        return userRepo.save(newUser);
    }


    public User login(LoginUser LoginUser, BindingResult result) {
        
    	Optional<User> awsomeUser = userRepo.findByEmail(LoginUser.getEmail());
    	
    	if(!awsomeUser.isPresent()) {
    		result.rejectValue("email", "Matches", "User not found!");
    		return null;
    	}
    	
    	User user = awsomeUser.get();
        
    	if(!BCrypt.checkpw(LoginUser.getPassword(), user.getPassword())) {
    	    result.rejectValue("password", "Matches", "Invalid Password!");
    	}
    	
    	if(result.hasErrors()) {
        	return null;
        }

    	return user;
    }
    
    public User findById(Long id) {
    	Optional<User> awsomeUser = userRepo.findById(id);
    	if(awsomeUser.isPresent()) {
    		return awsomeUser.get();
    	}
    	return null;
    }



}



