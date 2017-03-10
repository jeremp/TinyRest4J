
package org.jeremp.tinyrest4j.utils;

/**
 *
 * @author jpasseron
 */
public class StringUtils {

	public static boolean isNotBlank(String value){
		return (value!=null && value.trim().length()>0);
	}
	
}
