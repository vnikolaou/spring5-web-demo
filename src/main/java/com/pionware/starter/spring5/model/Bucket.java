package com.pionware.starter.spring5.model;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Bucket {
	private Long id;
	
	@Size(min=5) 
	private String name;
	private String zone;
	@NotNull
	private Date date;
	
	public Bucket() {
		super();
	}

	public Bucket(Long id, String name, String zone) {
		super();
		this.id = id;
		this.name = name;
		this.zone = zone;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}	
}
