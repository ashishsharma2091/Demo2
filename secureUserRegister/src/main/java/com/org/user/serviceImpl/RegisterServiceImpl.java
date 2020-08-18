package com.org.user.serviceImpl;

import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.user.model.UserRegister;
import com.org.user.repo.RegisterUserRepo;
import com.org.user.service.RegisterService;
import com.org.user.util.EncryptText;

@Service
public class RegisterServiceImpl implements RegisterService {
	 private RegisterUserRepo registerUserRepo;
	 
	 @Autowired
	public RegisterServiceImpl(RegisterUserRepo registerUserRepo  ) {
		  this.registerUserRepo=registerUserRepo;
		  
	  }
	
	@Override
	public UserRegister registerUser(UserRegister userRegister) {
		UserRegister userRegisterout=new UserRegister();
		String encryptedUserText=	EncryptText.encrypt(userRegister.getUserText());
		userRegister.setUserText(encryptedUserText);
		userRegisterout=registerUserRepo.save(userRegister);
		return userRegisterout;
		
		
		//RegisterUserRepo registerUserRepo=new RegisterUserRepo();
				// TODO Auto-generated method stub
				//EncryptText encryptText=new EncryptText();
				//String salt = EncryptText.getSalt(30);
				//String encryptedUserText=EncryptText.generateSecurePassword(userRegister.getUserText(), salt);
				//EncryptText.generateDecryptPassword(encryptedUserText);
	}

	@Override
	public Optional<UserRegister> getTextForUser(Long id) {
		// TODO Auto-generated method stub
		Optional<UserRegister> userRegisterout;
		userRegisterout=	registerUserRepo.findById(id);
		if(userRegisterout.isPresent()) {
			String encryptedUserText=userRegisterout.get().getUserText();
			userRegisterout.get().setUserText(EncryptText.decrypt(encryptedUserText))	;
		}
		return userRegisterout;
	}

}
