package org.jeremp.tinyrest4j.request;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import org.jeremp.tinyrest4j.utils.StringUtils;

/**
 *
 * @author jpasseron
 */
public class PostRequest extends RestRequest {

	private String body;

	public PostRequest(String url) {
		super("POST", url);
	}
	
	protected PostRequest(String url, String httpMethod){
		super(httpMethod, url);
	}

	@Override
	protected HttpURLConnection buildConnection() throws IOException {
		HttpURLConnection connection = super.buildConnection();
		connection.setDoOutput(true);
		if (StringUtils.isNotBlank(body)) {
			OutputStreamWriter osw = new OutputStreamWriter(connection.getOutputStream());
			osw.write(body);
			osw.flush();
			osw.close();
		}
		return connection;
	}

	public PostRequest withBody(String requestBody) {
		this.body = requestBody;
		return this;
	}

	@Override
	public PostRequest basicAuth(byte[] login, byte[] password) {
		super.basicAuth(login, password);
		return this;
	}

	@Override
	public PostRequest withParam(String name, String value) {
		super.withParam(name, value);
		return this;
	}
	
	

}
