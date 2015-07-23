package com.galionet.server.db.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.galionet.server.facade.model.BaseModel;



@Entity
@Table(name = "APP_USER")
public class AppUser extends BaseModel implements Serializable{

	private static final long serialVersionUID = -3461625688681856417L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "APP_USER_ID" , unique = true, nullable = false)
	private int userId;
	
	@Column(name = "NAME")
	private String name;

	@Column(name = "LAST_NAME")
	private String lastName;
	
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
}
