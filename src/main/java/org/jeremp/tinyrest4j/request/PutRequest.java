package org.jeremp.tinyrest4j.request;

import java.io.IOException;
import java.net.HttpURLConnection;

/**
 *
 * @author jpasseron
 */
public class PutRequest extends PostRequest {
	
	public PutRequest(String url) {
		super(url, "PUT");
	}

	@Override
	public PostRequest withParam(String name, String value) {
		return super.withParam(name, value); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public PutRequest basicAuth(byte[] login, byte[] password) {
		super.basicAuth(login, password);
		return this ;
	}

	@Override
	public PutRequest withBody(String requestBody) {
		super.withBody(requestBody);
		return this ;
	}

	@Override
	protected HttpURLConnection buildConnection() throws IOException {
		return super.buildConnection();
	}
	
	
	
}
