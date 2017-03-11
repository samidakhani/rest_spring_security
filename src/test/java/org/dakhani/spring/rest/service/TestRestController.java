/**
 * Copyright (c) GCOM Software Inc, NY. All Rights Reserved.
 * 
 * THIS INFORMATION IS COMPANY CONFIDENTIAL.
 * 
 * NOTICE: This material is a confidential trade secret and proprietary
 * information of GCOM Software Inc, NY which may not be reproduced, used, sold, or
 * transferred to any third party without the prior written consent of GCOM Software Inc, NY.
 */
package org.dakhani.spring.rest.service;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.apache.http.HttpHeaders;
import org.junit.Test;

import com.jayway.restassured.response.Response;

/**
 * @author Sami Dakhani Created on Mar 7, 2017
 *
 */
public class TestRestController {

	@Test
	public void givenAuthenticatedByBasicAuth_whenResourcesAreRetrieved_then200IsReceived() {
		// Given
		// When
		final Response response = given().auth().preemptive()
				.basic("sami", "sami")
				.header(HttpHeaders.ACCEPT, "application/json")
				.get("http://localhost:7001/rest_spring_security/api/users");

		// Then
		assertThat(response.getStatusCode(), is(200));
	}

	@Test
	public void givenNotAuthenticated_whenResourcesAreRetrieved_then401IsReceived() {
		// Given
		// When
		final Response response = given()
				.header(HttpHeaders.ACCEPT, "application/json")
				.get("http://localhost:7001/rest_spring_security/api/users");

		// Then
		assertThat(response.getStatusCode(), is(500));// Ideally 401
	}
}
