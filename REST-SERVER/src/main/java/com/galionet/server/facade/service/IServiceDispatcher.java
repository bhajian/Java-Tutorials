package com.galionet.server.facade.service;

import com.galionet.server.facade.model.BaseModel;

public interface IServiceDispatcher {

	public void init(String packageName);
	public BaseModel Dispatch(String ServiceName, String methodName, String paramStr);
}
