
package org.jeremp.tinyrest4j.request;

/**
 *
 * @author jpasseron
 */
public class DeleteRequest extends RestRequest{
	
	public DeleteRequest(String url) {
		super("DELETE", url);
	}

}
