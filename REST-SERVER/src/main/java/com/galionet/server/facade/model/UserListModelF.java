package com.galionet.server.facade.model;

import java.io.Serializable;
import java.util.List;

import com.galionet.server.db.model.AppUser;


public class UserListModelF extends BaseModel implements Serializable {

	private static final long serialVersionUID = -3461625688681856417L;
	private List<AppUser> userList;
	
	public List<AppUser> getUserList() {
		return userList;
	}
	public void setUserList(List<AppUser> userList) {
		this.userList = userList;
	}
	



}
