
package org.jeremp.tinyrest4j.utils;

/**
 *
 * @author jpasseron
 */
public class StringUtils {

	public static boolean isNotBlank(String value){
		return (value!=null && value.trim().length()>0);
	}

	public static boolean equalsIgnoreCase(String a, String b){
		if(a!=null){
			return a.equalsIgnoreCase(b);
		}
		return (b==null);
	}
	
}
