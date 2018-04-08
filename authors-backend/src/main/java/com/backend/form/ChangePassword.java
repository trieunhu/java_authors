package com.backend.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import com.backend.form.validator.FieldMatch;
import com.backend.form.validator.OldPasswordCompare;
@FieldMatch(first = "newPassword", second = "repeatPassword", message = "Hai mật khẩu không trùng nhau")
public class ChangePassword {
	
	
	@NotEmpty
	@Size(min = 6)
	@OldPasswordCompare
	private String oldPassword;
	@NotNull
	@Size(min = 6)
	private String newPassword;
	@NotNull
	@Size(min = 6)
	private String repeatPassword;

	
	public ChangePassword() {
		super();
	}
	public String getOldPassword() {
		return oldPassword;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public String getRepeatPassword() {
		return repeatPassword;
	}
	public void setRepeatPassword(String repeatPassword) {
		this.repeatPassword = repeatPassword;
	}
	
}
