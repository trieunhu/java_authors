package com.backend.form;

import org.hibernate.validator.constraints.NotEmpty;

public class ConfigForm {
	@NotEmpty
	private String nameApp;
	@NotEmpty
	private String contentFooter;
	private Integer numberPostBackend;
	private Integer numberPostFrontend;
	
	public ConfigForm() {
		super();
	}
	
	public ConfigForm(String nameApp, String contentFooter) {
		super();
		this.nameApp = nameApp;
		this.contentFooter = contentFooter;
	}
	

	public ConfigForm(String nameApp, String contentFooter, Integer numberPostBackend, Integer numberPostFrontend) {
		super();
		this.nameApp = nameApp;
		this.contentFooter = contentFooter;
		this.numberPostBackend = numberPostBackend;
		this.numberPostFrontend = numberPostFrontend;
	}

	public String getNameApp() {
		return nameApp;
	}
	public void setNameApp(String nameApp) {
		this.nameApp = nameApp;
	}
	public String getContentFooter() {
		return contentFooter;
	}
	public void setContentFooter(String contentFooter) {
		this.contentFooter = contentFooter;
	}

	public Integer getNumberPostBackend() {
		return numberPostBackend;
	}

	public void setNumberPostBackend(Integer numberPostBackend) {
		this.numberPostBackend = numberPostBackend;
	}

	public Integer getNumberPostFrontend() {
		return numberPostFrontend;
	}

	public void setNumberPostFrontend(Integer numberPostFrontend) {
		this.numberPostFrontend = numberPostFrontend;
	}
	
	
}
