package org.students.util;

public class StringUtil {

	
	public static boolean isEmpty(String str){
		if(str==null || "".equals(str.trim())){
			return true;
		}
		return false;
	}
	
	
	public static boolean isNotEmpty(String str){
		if(str==null || "".equals(str.trim())){
			return false;
		}
		return true;
	}
}
