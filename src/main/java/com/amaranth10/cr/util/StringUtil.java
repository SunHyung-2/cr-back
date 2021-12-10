package com.amaranth10.cr.util;

public class StringUtil {

	public static String fixNull(String str) {
	    if (str == null)
	      return ""; 
	    if (str.toLowerCase().equals("null"))
	      return ""; 
	    if (str.toLowerCase().equals("undefined"))
	      return ""; 
	    if (str.trim().length() == 0)
	      return ""; 
	    return str;
	  }
	  
	  public static String fixNull(Object obj) {
	    if (obj == null)
	      return ""; 
	    if (obj.toString().toLowerCase().equals("null"))
	      return ""; 
	    if (obj.toString().toLowerCase().equals("undefined"))
	      return ""; 
	    if (obj.toString().trim().length() == 0)
	      return ""; 
	    return obj.toString();
	  }
	  
	  public static String fixNull(Object obj, String str) {
	    if (obj == null)
	      return str; 
	    if (obj.toString().toLowerCase().equals("null"))
	      return str; 
	    if (obj.toString().toLowerCase().equals("undefined"))
	      return str; 
	    if (obj.toString().trim().length() == 0)
	      return str; 
	    return obj.toString();
	  }
}
