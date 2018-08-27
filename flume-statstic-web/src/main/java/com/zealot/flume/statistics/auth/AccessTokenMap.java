package com.zealot.flume.statistics.auth;

import java.util.HashMap;

public class AccessTokenMap {

	public static HashMap<String, String> map = new HashMap<String, String>() {  
		{  
	        put("e43f4a6066a664819a326957946058d2", "http://172.16.0.148");    
	    }  
	}; 
	
	public static boolean auth(String accessToken, String domain)
	{
		String v = map.get(accessToken);
		return domain.equals(v);
	}
}
