package com.kodb.util;

public class ParameterUtil {
	public static boolean isEmpty(String value){
	
		if(value==null || value.trim().length()==0){
			return true;
		}
		return false; 
	
	}

}
