package com.org.user.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UserRegister")
public class UserRegister {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long userID;
	//@Id
	@Column(name = "UserName")
	private String userName;
	@Column(name = "UserEMAIL")
	private String userEmail;
	@Column(name = "UserTEXT")
	private String userText;
	@Column(name = "resourceURI")
	private String resourceURI;
	
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserText() {
		return userText;
	}
	public void setUserText(String userText) {
		this.userText = userText;
	}
	@Override
	public String toString() {
		return "UserRegister [userName=" + userName + ", userEmail=" + userEmail + ", userText=" + userText + "]";
	}
	public Long getUserID() {
		return userID;
	}
	public void setUserID(Long userID) {
		this.userID = userID;
	}
	public String getResourceURI() {
		return resourceURI;
	}
	public void setResourceURI(String resourceURI) {
		this.resourceURI = resourceURI;
	}
	
	
}
