package com.galionet.server.facade.service;


import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Set;

import org.reflections.Reflections;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.galionet.server.facade.model.BaseModel;

@Service
public class ServiceDispatcher implements IServiceDispatcher {
	
	private static HashMap<String,Class> serviceSet=null;
	private static WebApplicationContext ctx;
	@Value("${path.to.scan_${env}}")
	private String pathToScan;
	
	@Override
	public BaseModel Dispatch(String ServiceName, String methodName, String paramStr) {
		if(serviceSet == null){
			init(pathToScan);
		}
		if(ctx == null){
			ctx = ContextLoader.getCurrentWebApplicationContext();
		}
		Class clazz=serviceSet.get(ServiceName);
		BaseService service=(BaseService)ctx.getBean(clazz);
		try {
			return service.handleRequest(methodName, paramStr);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void init(String packageName) {
		serviceSet=new HashMap<String, Class>();
		Reflections reflections = new Reflections(packageName);

	     Set<Class<? extends BaseService>> subTypes = 
	               reflections.getSubTypesOf(BaseService.class);
		for(Class c : subTypes){
			ServiceAnnotation sAn=(ServiceAnnotation) c.getAnnotation(ServiceAnnotation.class);
			if(sAn != null && sAn.name() != null){
				serviceSet.put(sAn.name(), c);
			}			
		}
	}

}
