package com.backend.form.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.MultipartFile;

@Component
public class TypeFileValidator implements Validator {
	public static final String MIME_TYPE="image/";
	private MultipartFile file;
	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object arg0, Errors errors) {
		if(file.isEmpty()){
			errors.rejectValue("file", "emplyUploadImage");
		}
		else if(!file.getContentType().startsWith(MIME_TYPE)){
			errors.rejectValue("file", "typeImageNotFomart");
		}
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
}
