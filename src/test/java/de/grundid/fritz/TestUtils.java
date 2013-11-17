package de.grundid.fritz;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.social.test.client.MockRestServiceServer;
import org.springframework.social.test.client.RequestMatchers;
import org.springframework.social.test.client.ResponseCreators;
import org.springframework.web.client.RestTemplate;

public class TestUtils {

	public static MockRestServiceServer prepareRestTemplateForLogin(RestTemplate restTemplate) {
		MockRestServiceServer mockServer = MockRestServiceServer.createServer(restTemplate);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setContentType(MediaType.APPLICATION_XML);
		mockServer
				.expect(RequestMatchers.requestTo("http://fritz.box/login_sid.lua"))
				.andExpect(RequestMatchers.method(HttpMethod.GET))
				.andRespond(
						ResponseCreators.withResponse(
								new ClassPathResource("login_sid_challenge.xml", ClassLoader.getSystemClassLoader()),
								responseHeaders));
		mockServer
				.expect(RequestMatchers.requestTo("http://fritz.box/login_sid.lua"))
				.andExpect(RequestMatchers.method(HttpMethod.POST))
				.andRespond(
						ResponseCreators.withResponse(
								new ClassPathResource("login_sid_ok.xml", ClassLoader.getSystemClassLoader()),
								responseHeaders));
		return mockServer;
	}
}
