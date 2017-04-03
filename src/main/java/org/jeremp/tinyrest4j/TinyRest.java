package org.jeremp.tinyrest4j;

import java.util.HashMap;
import java.util.Map;
import org.jeremp.tinyrest4j.request.DeleteRequest;
import org.jeremp.tinyrest4j.request.GetRequest;
import org.jeremp.tinyrest4j.request.PostRequest;
import org.jeremp.tinyrest4j.request.PutRequest;
import org.jeremp.tinyrest4j.request.RestRequest;
import org.jeremp.tinyrest4j.utils.Constants;
import org.jeremp.tinyrest4j.utils.TinyUtils;

/**
 *
 * @author jpasseron
 */
public class TinyRest {

	private final Map<String, String> alwaysAppliedHeaders = new HashMap<>();
	
	public GetRequest get(String url){
		GetRequest getRequest = new GetRequest(url);		
		getRequest = (GetRequest) appliesHeaders(getRequest);
		return getRequest ;
	}
	
	public DeleteRequest delete(String url){
		DeleteRequest deleteRequest = new DeleteRequest(url);
		deleteRequest = (DeleteRequest) appliesHeaders(deleteRequest);		
		return deleteRequest ;
	}
	
	public PostRequest post(String url){
		PostRequest postRequest = new PostRequest(url);
		postRequest = (PostRequest) appliesHeaders(postRequest);
		return postRequest ;
	}	

	public PutRequest put(String url){
		PutRequest putRequest = new PutRequest(url);
		putRequest = (PutRequest) appliesHeaders(putRequest);
		return putRequest ;
	}
	
	public RestRequest appliesHeaders(RestRequest restRequest){
		if(alwaysAppliedHeaders.isEmpty()==false){
			for(String key : alwaysAppliedHeaders.keySet()){
				restRequest.addHeader(key, alwaysAppliedHeaders.get(key));
			}
		}
		return restRequest;
	}
	
	public TinyRest alwaysApplyHeader(String name, String value){
		alwaysAppliedHeaders.put(name, value);
		return this;
	}
	
	public TinyRest alwaysApplyBasicAuth(byte[] login, byte[] password){
		alwaysApplyHeader(Constants.AUTH_HEADER_NAME, TinyUtils.produceBasicAuthHeaderValue(login, password));
		return this ;
	}
}
