
package org.jeremp.tinyrest4j;

import org.jeremp.tinyrest4j.request.RestResponse;
import org.junit.Test;
import org.junit.BeforeClass;


/**
 *
 * @author jpasseron
 */
public class TinyRestClientTest {
	
	
	@BeforeClass
	public static void beforeClass(){
		/*
		System.setProperty("http.proxyHost", "vipproxy1.prod.extelia.fr");
		System.setProperty("http.proxyPort", "8080");	
		System.setProperty("https.proxyHost", "vipproxy1.prod.extelia.fr");
		System.setProperty("https.proxyPort", "8080");
        */
	}

	@Test
	public void testGet() {
		String url = "http://petstore.swagger.io/v2/pet/findByStatus";
		TinyRest tinyRestClient = new TinyRest();		
		RestResponse result = tinyRestClient.get(url).basicAuth("prm".getBytes(), "prm".getBytes()).withParam("status", "available").doRequest();
	}
	
}
