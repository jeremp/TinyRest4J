
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
		
		System.setProperty("http.proxyHost", "vipproxy1.prod.extelia.fr");
		System.setProperty("http.proxyPort", "8080");	
		System.setProperty("https.proxyHost", "vipproxy1.prod.extelia.fr");
		System.setProperty("https.proxyPort", "8080");
        
	}

	@Test
	public void testGet() {
		TinyRest tinyRestClient = new TinyRest();			
		String url = "http://petstore.swagger.io/v2/pet/findByStatus";			
		RestResponse result = tinyRestClient.get(url).basicAuth("prm".getBytes(), "prm".getBytes()).withParam("status", "available").doRequest();
		
		/*
		String deleteURL = "http://vivoptimdev.extelia.fr:8080/vivoptim-ws/rest/admin/docasante/deleteDoc?idVivoptim=0101083597&idDocument=654";
		tinyRestClient.delete(deleteURL).basicAuth("prm".getBytes(), "prm".getBytes()).doRequest();
	
		String postURL = "http://vivoptimdev.extelia.fr:8080/vivoptim-ws/rest/admin/docasante/searchRegistry?idVivoptim=100109038";
		tinyRestClient.post(postURL).basicAuth("prm".getBytes(), "prm".getBytes()).withBody("{}").withHeader("Content-Type", "application/json").doRequest();
		*/
	}
	
}
