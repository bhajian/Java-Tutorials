package com.galionet.server.facade.model;

import java.io.InputStream;
import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnore;

public class BaseModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8799694549870351056L;
	@JsonIgnore
	private boolean hasAttachment;
	@JsonIgnore
	private InputStream attachment=null;
	@JsonIgnore
	private String filePath;
	
	public boolean isHasAttachment() {
		return hasAttachment;
	}
	public void setHasAttachment(boolean hasAttachment) {
		this.hasAttachment = hasAttachment;
	}
	@JsonIgnore
	public InputStream getAttachment() {
		return attachment;
	}
	public void setAttachment(InputStream attachment) {
		this.attachment = attachment;
	}
	@JsonIgnore
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
}
