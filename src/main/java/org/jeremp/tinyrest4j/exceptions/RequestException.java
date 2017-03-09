package org.jeremp.tinyrest4j.exceptions;

import java.io.IOException;

/**
 *
 * @author jpasseron
 */
public class RequestException extends RuntimeException {

	public RequestException(IOException ex) {
		super(ex);
	}
	
}
