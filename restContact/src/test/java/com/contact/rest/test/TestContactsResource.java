/**
 * 
 *//*
package com.contact.rest.test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.net.URI;
import java.net.URISyntaxException;

import javax.ws.rs.core.MediaType;
import org.junit.Assert;
import javax.ws.rs.core.UriBuilder;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.contact.bean.Contact;
import com.contact.client.ContactClient;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.representation.Form;
import com.sun.jersey.test.framework.AppDescriptor;
import com.sun.jersey.test.framework.JerseyTest;
import com.sun.jersey.test.framework.WebAppDescriptor;


*//**
 * @author rootlocal
 *
 *//*
public class TestContactsResource extends JerseyTest {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	ContactClient c=new ContactClient();
	Client cli = Client.create();
	WebResource r = cli.resource("http://localhost:8080/Jersey/rest/contacts");	

	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
		System.setErr(new PrintStream(errContent));
	}

	@After
	public void cleanUpStreams() {
		System.setOut(null);
		System.setErr(null);
	}

	@Override
	protected AppDescriptor configure() {
		return new WebAppDescriptor.Builder().build();
	}

	@Override
	public URI getBaseURI() {
		return UriBuilder.fromUri("http://localhost:8080/restContact/rest/contacts/").build();
	}

	@Test
	public void testGetContactById() {
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		WebResource service = client.resource(getBaseURI());
		ClientResponse response = service.path("contact").path("at")
				.accept(MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON).get(ClientResponse.class);
		Contact contact = (Contact) response.getEntity(Contact.class);
		//assertEquals("Kate", contact.getName());
	}
	
	
}
*/