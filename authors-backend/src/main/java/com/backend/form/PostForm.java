package com.backend.form;


import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

public class PostForm {
	@NotEmpty
	private String title;
	private String description;
	@NotEmpty
	private String status;
	private String slug;
	private MultipartFile file;
	private String sub_title;

	public PostForm() {
	}
	

	public PostForm(String title, String description, String status, String slug) {
		super();
		this.title = title;
		this.description = description;
		this.status = status;
		this.slug = slug;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getSlug() {
		return slug;
	}


	public void setSlug(String slug) {
		this.slug = slug;
	}


	public MultipartFile getFile() {
		return file;
	}


	public void setFile(MultipartFile file) {
		this.file = file;
	}


	public String getSubTitle() {
		return sub_title;
	}


	public void setSubTitle(String sub_title) {
		this.sub_title = sub_title;
	}
	
	
	
}
