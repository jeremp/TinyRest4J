package org.jeremp.tinyrest4j;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.assertj.core.api.Assertions;
import org.jeremp.tinyrest4j.request.GetRequest;
import org.jeremp.tinyrest4j.request.RestResponse;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author jpasseron
 */
public class GetRequestTest {
	
	private static final Logger log = LoggerFactory.getLogger(GetRequestTest.class);

	@BeforeClass
	public static void beforeClass(){
		System.setProperty("http.proxyHost", "vipproxy1.prod.extelia.fr");
		System.setProperty("http.proxyPort", "8080");	
	}
	
	@Test
	public void testGet() {
		String url = "http://stackoverflow.com";
		GetRequest getRequest = new GetRequest(url);
		RestResponse resp = getRequest.doRequest();
		log.info("response={}", ToStringBuilder.reflectionToString(resp, ToStringStyle.JSON_STYLE));
		assertThat(resp).isNotNull();
		assertThat(resp.getStatus()).withFailMessage("%s statuts code shoud be 200", url).isEqualTo(200);
	}
	
}
