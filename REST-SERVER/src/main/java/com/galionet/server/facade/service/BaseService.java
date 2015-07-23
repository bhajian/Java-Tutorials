package com.galionet.server.facade.service;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.galionet.server.facade.model.BaseModel;

public abstract class BaseService {

	private HashMap<String, Method> methodSet = null;
	private ObjectMapper mapper = new ObjectMapper();

	public void init() {
		methodSet = new HashMap<String, Method>();
		Method[] methods = this.getClass().getDeclaredMethods();
		for (Method m : methods) {
			MethodAnnotation an = m.getAnnotation(MethodAnnotation.class);
			if (an != null && an.name() != null) {
				methodSet.put(an.name(), m);
			}
		}
	}

	public BaseModel handleRequest(String method, String paramStr) throws IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		if (methodSet == null) {
			init();
		}
		Method calledMethod = methodSet.get(method);
		Class[] clazzes = calledMethod.getParameterTypes();
		BaseModel param = null;
		if (clazzes != null && clazzes.length > 0) {
			param = deserializeParameter(paramStr, clazzes[0]);
		}
		if (calledMethod != null) {
			calledMethod.setAccessible(true);
			return (BaseModel) calledMethod.invoke(this, param);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	private BaseModel deserializeParameter(String paramStr, Class clazz) {
		try {
			return (BaseModel) mapper.readValue(paramStr, clazz);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
