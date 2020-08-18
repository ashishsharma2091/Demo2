package com.org.user.registerSecure;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.org.user.model.UserRegister;
import com.org.user.model.UserRegisterFromDB;
import com.org.user.service.RegisterService;
import com.org.user.serviceImpl.RegisterServiceImpl;
import com.org.user.transformer.UserDetailTransformer;

@Controller
@Component
public class RegistrationController {

	
	private RegisterService registerService;
	private UserDetailTransformer userDetailTransformer;
	
	
	  @Autowired 
	  public void setRegisterSevice(RegisterService registerService) {
	  this.registerService=registerService; }
	  
	  @Autowired
	  public void setUserDetailTransformer(UserDetailTransformer userDetailTransformer) {
		  this.userDetailTransformer=userDetailTransformer;
	  }
	 
	
	/*
	 * @Autowired public void setUserRegister(UserRegister userRegister) {
	 * this.userRegister=userRegister; }
	 */
	
	@RequestMapping("/regForm")
	public String register() {
		return "registration";
	}
	
	@RequestMapping("/saveDetails")                     // it only support port method
    public ModelAndView saveDetails(UserRegister ur) {
		UserRegisterFromDB UserRegisterout=new UserRegisterFromDB();
		//ur.setResourceURI("/getUserText/"+ur.getUserID());
		String flowType="saveConfirmation";
		userDetailTransformer.transformUserDetails(registerService.registerUser(ur), UserRegisterout,flowType);
		//UserRegisterout=registerService.registerUser(ur);
		
		List<UserRegisterFromDB> userList=new ArrayList<UserRegisterFromDB>();
		userList.add(UserRegisterout);
		
		/*
		 * ModelMap modelMap=new ModelMap(); modelMap.addAttribute("userList",
		 * userList);
		 */
		/*
		 * modelMap.addAttribute("userName", UserRegisterout.getUserName());
		 * modelMap.addAttribute("userEmail", UserRegisterout.getUserEmail());
		 * modelMap.addAttribute("userText", UserRegisterout.getUserText());
		 * modelMap.addAttribute("resourceURI", UserRegisterout.getResourceURI());
		 */
		 
		
		 ModelAndView modelAndView=new ModelAndView();
		 modelAndView.setViewName("user-details");
		  modelAndView.addObject("userList",userList);
		 
        return modelAndView;           // welcome is view name. It will call welcome.jsp
    }
	
	@RequestMapping("/getUserText/{id}")                     // it only support port method
    public ModelAndView getUserDetails(@PathVariable Long id) {
		UserRegisterFromDB userRegisterout=new UserRegisterFromDB();
        // write your code to save details
		UserRegister userRegister=null;
		Optional<UserRegister> UserRegisterOptional=registerService.getTextForUser(id);
		if(UserRegisterOptional.isPresent()) {
			userRegister=	UserRegisterOptional.get();
		}
		String flow="userTextdetails";
		userDetailTransformer.transformUserDetails(userRegister, userRegisterout, flow);
		
		  ModelMap modelMap=new ModelMap();
		
		 
		  List<UserRegisterFromDB> userList=new ArrayList<UserRegisterFromDB>();
			userList.add(userRegisterout);
			ModelAndView modelAndView=new ModelAndView();
			 modelAndView.setViewName("user-details");
			  return modelAndView.addObject("userList",userList);
    }
	
	
	
	
	/**
	 *  It will directly pick the value from request - not java object
	 * @param userName
	 * @param userEmail
	 * @param userText
	 * @param modelMap
	 * @return
	 */
	/*
	 * @RequestMapping("/saveDetails") // it only support port method public String
	 * saveDetails(@RequestParam("userName") String userName,
	 * 
	 * @RequestParam("userEmail") String userEmail,
	 * 
	 * @RequestParam("userText") String userText, ModelMap modelMap) { // write your
	 * code to save details modelMap.put("userName", userName);
	 * modelMap.put("userEmail", userEmail); modelMap.put("userText", userText);
	 * return "user-details"; // welcome is view name. It will call welcome.jsp }
	 */
	
	
}


