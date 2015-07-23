package com.galionet.server.facade.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.galionet.server.db.dao.AppUserDao;
import com.galionet.server.db.model.AppUser;
import com.galionet.server.facade.model.BaseModel;
import com.galionet.server.facade.model.UserListModelF;



@Transactional
@Service
@ServiceAnnotation(name = "user")
public class UsersService extends BaseService {
	private AppUserDao appUserDao;

	@MethodAnnotation(name = "getUsers")
	public BaseModel getData(BaseModel param) {
		UserListModelF result = new UserListModelF();
		result.setUserList(appUserDao.getAllUsers());
		return result;
	}

	@MethodAnnotation(name = "createUser")
	public BaseModel createUser(AppUser param) {
		if (param != null) {
			param.setUserId((Integer) appUserDao.createObject(param));
			return param;
		}
		return null;
	}

	@Autowired
	public void setAppUserDao(AppUserDao appUserDao) {
		this.appUserDao = appUserDao;
	}
}
