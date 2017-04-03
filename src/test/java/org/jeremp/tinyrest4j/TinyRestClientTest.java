
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

	}

	@Test
	public void testGet() {
		TinyRest tinyRestClient = new TinyRest().alwaysApplyHeader("Content-Type", "application/json").alwaysApplyBasicAuth("prm".getBytes(), "prm".getBytes());			
		/*
		String url = "http://petstore.swagger.io/v2/pet/findByStatus";			
		RestResponse result = tinyRestClient.get(url).basicAuth("prm".getBytes(), "prm".getBytes()).withParam("status", "available").doRequest();
		
		*/
		String deleteURL = "http://vivoptimdev.extelia.fr:8080/vivoptim-ws/rest/admin/docasante/deleteDoc?idVivoptim=0101083597&idDocument=654";
		tinyRestClient.delete(deleteURL).basicAuth("prm".getBytes(), "prm".getBytes()).doRequest();
	
		String postURL = "http://vivoptimdev.extelia.fr:8080/vivoptim-ws/rest/admin/docasante/searchRegistry?idVivoptim=100109038";
		tinyRestClient.post(postURL).basicAuth("prm".getBytes(), "prm".getBytes()).withBody("{}").doRequest();
		
		String putUrl = "http://vivoptimdev.extelia.fr:8080/vivoptim-ws/rest/participant/suspension?suspensionType=INACTIVITE&ID_VIVOPTIM=100109038";
		RestResponse response = tinyRestClient.put(putUrl).withBody("{}").doRequest();
		
	}
	
}
