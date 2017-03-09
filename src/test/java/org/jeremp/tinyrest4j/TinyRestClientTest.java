
package org.jeremp.tinyrest4j;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.jeremp.tinyrest4j.request.GetRequest;
import org.jeremp.tinyrest4j.request.RestResponse;
import org.junit.Test;
import static org.junit.Assert.*;
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
		System.out.println("get");
		String url = "http://vivoptimdev.extelia.fr:8080/vivoptim-ws/";
		TinyRestClient tinyRestClient = new TinyRestClient();		
		RestResponse result = tinyRestClient.get(url).basicAuth("prm".getBytes(), "prm".getBytes()).withParam("q", "toto").doRequest();
		System.out.println(""+ToStringBuilder.reflectionToString(result, ToStringStyle.MULTI_LINE_STYLE));
		
	}
	
}
