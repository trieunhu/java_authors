package com.backend.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.context.MessageSource;


@Entity
@Table(name = "posts")
public class Post implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@NotEmpty
	private String title;
	@Lob
	@Basic(fetch=FetchType.LAZY)
	@Column(name = "description")
	private String description;
	private String status;
	private String slug;
	@Column(name = "views")
	private Integer views;
	private Date created_at;
	private Date updated_at;
	@Column(name = "image")
	private String image;
	@Column(name = "sub_title")
	private String sub_title;
	public static final String ACTIVE = "active";
	public static final String DEACTIVE = "deactive";

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User user;

	public String getImage() {
		return image;
	}

	@Transient
	public String getUrlImage() {
		return "/images/" + image;
	}
	
	@Transient
	public String getUrl() {
		return "/chi-tiet/" + slug;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getSubtitle() {
		return sub_title;
	}

	public void setSubtitle(String sub_title) {
		this.sub_title = sub_title;
	}

	public Post(String title, String description, String status, String slug) {
		super();
		this.title = title;
		this.description = description;
		this.status = status;
		this.slug = slug;
		this.created_at = new Date();
		this.updated_at = new Date();
		this.views = 0;
	}

	public Post( String title, String description, String status, Integer views) {
		this.title = title;
		this.description = description;
		this.status = status;
		this.views = views;
		this.created_at = new Date();
	}

	public Post() {
		super();
	}

	
	public Integer getId() {
		return id;
	}

	@Column(name = "slug")
	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "title")
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

	@Column(name = "status")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "created_at")
	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	@Column(name = "updated_at")
	public Date getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}

	public Integer getViews() {
		return views;
	}

	public void setViews(Integer views) {
		this.views = views;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	@Transient
	public String getStatusText(Locale locale,MessageSource messageSource) {
		if	(status.equals(ACTIVE)) {
			return messageSource.getMessage("STATUS_ACTIVE",null, locale);
		}
		return messageSource.getMessage("STATUS_DEACTIVE",null, locale);
	}
	public static Map<String, String> listStatus(MessageSource messageSource,Locale locale) {
		Map<String, String> map = new HashMap<String, String>();
		map.put(ACTIVE, messageSource.getMessage("STATUS_ACTIVE", null, locale));
		map.put(DEACTIVE, messageSource.getMessage("STATUS_DEACTIVE", null, locale));
		return map;
	}

	
}
