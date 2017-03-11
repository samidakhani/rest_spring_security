package org.dakhani.spring.util;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @author Sami Dakhani Created on Mar 6, 2017
 *
 */
public class JSONUtil {

	/**
	 * Converts Java object into JSON string
	 * 
	 * @param obj
	 * @return
	 */
	public static String getJsonString(final Object obj) {
		String jsonString = null;

		try {

			ObjectMapper mapper = new ObjectMapper();

			// Object to JSON in String
			jsonString = mapper.writeValueAsString(obj);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonString;
	}
}
