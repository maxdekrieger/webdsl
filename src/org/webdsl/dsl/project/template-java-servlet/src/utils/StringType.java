package utils;

import java.util.*;

public class StringType {
    
    public static Integer parseInt(String s){
      try{
    	  return Integer.parseInt(s);
      }
      catch(Exception e){
    	  return null;
      }
    }
    public static java.util.UUID parseUUID(String s){
    	try{
    		return java.util.UUID.fromString(s);
    	}
    	catch(Exception e){
    		return null;
    	}
    }
    
    public static String concatWithSeparator(List<String> s, String sep){
        StringBuffer ret = new StringBuffer();
        for(String str : s){
        	if(ret.length() == 0){
        		ret.append(str);
        	}
        	else{
        		ret.append(sep);
        		ret.append(str);
        	}
        }
        return ret.toString();
    }
    
}