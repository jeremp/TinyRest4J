package org.jeremp.tinyrest4j.request;

/**
 *
 * @author jpasseron
 */
public class GetRequest extends RestRequest {

	public GetRequest(String url) {
		super("GET", url);				
	}

}
