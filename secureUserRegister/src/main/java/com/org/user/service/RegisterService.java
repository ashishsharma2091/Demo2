package com.org.user.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.org.user.model.UserRegister;


public interface RegisterService {

	public UserRegister registerUser(UserRegister userRegister);
	public Optional<UserRegister> getTextForUser(Long id);
}
