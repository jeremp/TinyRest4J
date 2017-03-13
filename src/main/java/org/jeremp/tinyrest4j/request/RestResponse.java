package org.jeremp.tinyrest4j.request;

import java.util.List;
import java.util.Map;

/**
 *
 * @author jpasseron
 */
public class RestResponse {
	
	private final int status;
	private final Map<String, List<String>> headers ;
	private final String body ;

	public RestResponse(int status, Map<String, List<String>> headers, String body) {
		this.status = status;
		this.headers = headers;
		this.body = body;
	}

	public int getStatus() {
		return status;
	}

	public Map<String, List<String>> getHeaders() {
		return headers;
	}

	public String getBody() {
		return body;
	}

	@Override
	public String toString() {
		return "RestResponse{" +
				"\n\tstatus=" + status +
				",\n\theaders=" + headers +
				",\n\tbody='" + body + '\'' +
				"\n}";
	}
}
