package org.jeremp.tinyrest4j.request;

import org.jeremp.tinyrest4j.utils.Constants;
import java.io.BufferedReader;
import org.jeremp.tinyrest4j.exceptions.RequestException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import org.jeremp.tinyrest4j.exceptions.InvalidUrlException;
import org.jeremp.tinyrest4j.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author jpasseron
 */
public abstract class RestRequest {
	
	private static final Logger LOG = LoggerFactory.getLogger(RestRequest.class);
	
	protected String httpMethod ;
	protected Map<String, String> parameters = new HashMap<>();
	protected Map<String, String> headers = new HashMap<>();
	protected URL url ;	

	public RestRequest(String httpMethod, String url) {
		this.httpMethod = httpMethod;
		try {
			this.url = new URL(url);
		} catch (MalformedURLException ex) {
			throw new InvalidUrlException(ex);
		}
	}

	public RestResponse doRequest() {		
		try {

			HttpURLConnection connection = buildConnection();

			if(LOG.isDebugEnabled()){
				LOG.debug(this.toString());
			}

			int responseCode = connection.getResponseCode();			
			Charset responseCharset = Constants.DEFAULT_RESPONSE_CHARSET ;
			if(StringUtils.isNotBlank(connection.getContentEncoding())){				
				responseCharset = Charset.forName(connection.getContentEncoding());				
			}
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(), responseCharset));
			String inputLine;
			StringBuilder response = new StringBuilder();		
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			RestResponse restResponse = new RestResponse(responseCode, connection.getHeaderFields(), response.toString());

			if(LOG.isDebugEnabled()){
				LOG.debug(restResponse.toString());
			}

			return restResponse ;
		} catch (IOException ex) {
			throw new RequestException(ex);
		}		
	}
	public RestRequest withParam(String name, String value){
		this.addParameter(name, value);
		return this ;
	}
	
	public RestRequest basicAuth(byte[] login, byte[] password) {	
		byte[] semicolumn = ":".getBytes(Constants.UTF8);
		int fullLength = login.length + semicolumn.length + password.length ;
		byte[] fullArray = new byte[fullLength];		
		ByteBuffer target = ByteBuffer.wrap(fullArray);
		target.put(login);
		target.put(semicolumn);
		target.put(password);		
		String b64EncodedData = Base64.getEncoder().encodeToString(target.array());
		this.addHeader("Authorization", "Basic "+b64EncodedData);
		return this ;
	}

	public void addParameter(String name, String value){
		parameters.put(name, value);
	}
	
	public void addHeader(String name, String value){
		headers.put(name, value);
	}
	
	/*---Good Old Getters and Setter---*/
	
	public Map<String, String> getParameters() {
		return parameters;
	}
	
	public Map<String, String> getHeaders() {
		return headers;
	}

	public URL getUri() {
		return url;
	}
	
	private HttpURLConnection buildConnection() throws IOException {
		url = buildUrlWithParameters();
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod(httpMethod);
		
		// add headers
		if(headers.isEmpty()==false){
			for(String headerName : headers.keySet()){
				connection.addRequestProperty(headerName, headers.get(headerName));
			}
		}
		
		return connection ;
	}

	@Override
	public String toString() {
		return "RestRequest{" + "httpMethod=" + httpMethod + ",\nparameters=" + parameters + ",\nheaders=" + headers + ",\nurl=" + url + '}';
	}

	private URL buildUrlWithParameters() throws UnsupportedEncodingException, MalformedURLException {
		if(parameters.isEmpty()){
			return url ;
		}else{
			String fullURL = url.toExternalForm();
			if(StringUtils.isNotBlank(url.getQuery())){
				fullURL += "&" ;
			}else{
				fullURL += "?" ;
			}
			int index = 0 ;
			for(String name : parameters.keySet()){
				index++ ;
				fullURL = fullURL + name + "=" + URLEncoder.encode(parameters.get(name), "UTF-8");
				if(index < parameters.size()){
					fullURL += "&" ;
				}
			}
			return new URL(fullURL);
		}
	}
	
	
	
}
