package com.galionet.server.facade.constants;



public enum ResourceType {
	MUSIC_MP3((short)1, "mp3"),
	VIDEO_AVI((short)2, "avi"),
	PHOTO_JPG((short)3, "jpg"),
	PHOTO_PNG((short)3, "png"),
	FILE((short)0, ""),
	TEXT_FILE((short)0, "txt");
	
	public short value;
	public String extension;
	
	ResourceType (short value, String extension){
		this.value=value;
		this.extension=extension;
	}
	
	
	public static ResourceType getResourceType(short value){
		for(ResourceType rt:ResourceType.values()){
			if(value == rt.value){
				return rt;
			}
		}
		return FILE;
	}
}
