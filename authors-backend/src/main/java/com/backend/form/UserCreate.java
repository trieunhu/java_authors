package com.backend.form;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.backend.form.validator.UniqueField;

public class UserCreate {
	@NotEmpty
	@Email
	@UniqueField(fieldName ="email")
	private String email;
	
	@NotEmpty
	private String fullname;
	
	@NotEmpty
	@Size(min = 6)
	private String password;
	
	@NotEmpty
	@UniqueField(fieldName ="username")
	private String username;
	
	
	public UserCreate() {
	}
	public UserCreate(String email, String fullname, String password, String username) {
		super();
		this.email = email;
		this.fullname = fullname;
		this.password = password;
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
}
