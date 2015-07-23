package com.galionet.server.webService;


import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.galionet.server.facade.model.BaseModel;
import com.galionet.server.facade.service.IServiceDispatcher;



@Component
@Path("/Gate")
public class GateService {

	private static transient Logger logger = Logger.getLogger(GateService.class);
	private static ObjectMapper mapper = new ObjectMapper();
	private IServiceDispatcher serviceDispatcher;

	@GET
	@Path("GetData")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Response getData(@Context HttpServletRequest request) throws JsonGenerationException, JsonMappingException,
			IOException {
		try {
			String command = request.getHeader("command");
			String subCommand = request.getHeader("subCommand");
			String param = request.getHeader("param");
			BaseModel res = getServiceDispatcher().Dispatch(command, subCommand, (param != null ? param : ""));

			if (res.isHasAttachment()) {
				return Response.ok(res.getAttachment(), MediaType.APPLICATION_OCTET_STREAM_TYPE).build();
			} else {
				return Response.status(200).entity(mapper.writeValueAsString(res)).build();
			}
		} catch (Exception e) {
			logger.error(e);
			return Response.status(200).entity("error").build();
		}
	}

	@Path("PostData")
	@POST
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	@Consumes("application/x-www-form-urlencoded")
	public Response postData(@Context HttpServletRequest request, @FormParam("param") String param)
			throws JsonGenerationException, JsonMappingException, IOException {
		try {

			String command = request.getHeader("command");
			String subCommand = request.getHeader("subCommand");
			BaseModel res = getServiceDispatcher().Dispatch(command, subCommand, param);
			if (res.isHasAttachment()) {
				return Response.ok(res.getAttachment(), MediaType.APPLICATION_OCTET_STREAM_TYPE).build();
			} else {
				return Response.status(200).entity(mapper.writeValueAsString(res)).build();
			}
		} catch (Exception e) {
			logger.error(e);
			return Response.status(200).entity("error").build();
		}
	}

	public IServiceDispatcher getServiceDispatcher() {
		WebApplicationContext ctx = ContextLoader.getCurrentWebApplicationContext();
		if (this.serviceDispatcher != null) {
			return this.serviceDispatcher;
		} else {
			this.serviceDispatcher = (IServiceDispatcher) ctx.getBean("serviceDispatcher");
			return this.serviceDispatcher;
		}
	}

}
