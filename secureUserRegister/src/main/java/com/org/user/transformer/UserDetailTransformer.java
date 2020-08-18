package com.org.user.transformer;

import org.springframework.stereotype.Component;

import com.org.user.model.UserRegister;
import com.org.user.model.UserRegisterFromDB;

@Component
public class UserDetailTransformer {
	
	public UserRegisterFromDB transformUserDetails(UserRegister userRegister,UserRegisterFromDB outUserdetail,String flow) {
		outUserdetail.setResourceURI(userRegister.getResourceURI());
		outUserdetail.setUserEmail(userRegister.getUserEmail());
		outUserdetail.setUserName(userRegister.getUserName());
		outUserdetail.setFlowType(flow);
		outUserdetail.setUserID(userRegister.getUserID());
		if((flow=="userTextdetails")) {
			outUserdetail.setUserText(userRegister.getUserText());
		}
		return outUserdetail;
		
	}

}
