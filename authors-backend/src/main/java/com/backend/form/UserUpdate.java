package com.backend.form;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

public class UserUpdate {
	@NotEmpty
	private String email;
	@NotEmpty
	private String fullname;
	private MultipartFile file;
	
	
	public UserUpdate() {
		super();
	}
	public UserUpdate(String email, String fullname) {
		super();
		this.email = email;
		this.fullname = fullname;
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
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
}
