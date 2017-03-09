
package org.jeremp.tinyrest4j.exceptions;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

/**
 *
 * @author jpasseron
 */
public class InvalidUrlException extends RuntimeException {

	public InvalidUrlException(MalformedURLException ex) {
		super(ex);
	}
	
}
