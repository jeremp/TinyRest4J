package org.jeremp.tinyrest4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jeremp.tinyrest4j.request.GetRequest;

/**
 *
 * @author jpasseron
 */
public class TinyRest {

	private Map<String, List<String>> alwaysAppliedHeaders = new HashMap<>();
	
	public GetRequest get(String url){
		return new GetRequest(url);		
	}
}
