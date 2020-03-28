package com.capg.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.demo.exceptions.UserNotFoundException;
import com.capg.demo.model.User;
import com.capg.demo.repository.UserJpaRepo;
import com.capg.demo.repository.UserRepo;

@Service
public class UserService {
	@Autowired
	UserRepo repo;
	@Autowired
	UserJpaRepo jpaRepo;
	@Transactional
	public User saveUser(User user) {
		repo.saveUser(user);
		return getUserByEmail(user.getEmail());
	}
	public User getUserByEmail(String email) {
		return jpaRepo.checkByEmail(email);
		//return jpaRepo.getByEmail(email);
	}
	public List<User> getAllUser(){
		return jpaRepo.findAll();
	}
	public boolean deleteUser(String email) {
		User user=jpaRepo.checkByEmail(email);
		if(user==null) {
			throw new UserNotFoundException("No user found with email : "+email);
		}
		jpaRepo.delete(user);
		return jpaRepo.existsById(user.getUserId());
	}

}
