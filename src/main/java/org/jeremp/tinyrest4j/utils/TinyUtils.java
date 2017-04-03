package org.jeremp.tinyrest4j.utils;

import java.nio.ByteBuffer;
import java.util.Base64;

/**
 *
 * @author jpasseron
 */
public class TinyUtils {

	public static String produceBasicAuthHeaderValue(byte[] login, byte[] password) {
		byte[] semicolumn = ":".getBytes(Constants.UTF8);
		int fullLength = login.length + semicolumn.length + password.length;
		byte[] fullArray = new byte[fullLength];
		ByteBuffer target = ByteBuffer.wrap(fullArray);
		target.put(login);
		target.put(semicolumn);
		target.put(password);
		String b64EncodedData = Base64.getEncoder().encodeToString(target.array());
		return "Basic " + b64EncodedData;
	}

}
