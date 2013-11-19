package de.grundid.fritz;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

public class FritzTemplateTest {

	private FritzTemplate fritzTemplate;

	@Before
	public void before() {
		RestTemplate restTemplate = new RestTemplate();
		TestUtils.prepareRestTemplateForLogin(restTemplate);
		fritzTemplate = new FritzTemplate(restTemplate, "test");
	}

	@Test
	public void itShouldCreateResponseForChallenge() throws Exception {
		String response = fritzTemplate.createChallengeResponse("0d5f2bde", "test");
		assertEquals("0d5f2bde-e69f4871072bd4044141e7d5f0252c37", response);
	}

	@Test
	public void itShouldGetSessionId() throws Exception {
		String sessionId = fritzTemplate.getSessionId();
		assertEquals("1234567890", sessionId);
	}
}