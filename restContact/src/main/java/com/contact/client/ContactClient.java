package com.contact.client;


import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBElement;

import com.contact.bean.Contact;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.representation.Form;

public class ContactClient {
	
	public static void main(String[] args) {
		Client c = Client.create();
		WebResource r = c.resource("http://localhost:8080/Jersey/rest/contacts");		
		getOneContact(r, "bar");		
		postForm(r, "foo", "bar","tar","123");
		Contact cnt = new Contact("id", "name","address","908765");
		putOneContact(r, cnt);
		getContacts(r);		
		deleteOneContact(r, "foo");		
		getContacts(r);
	}
	
	public static void getContacts(WebResource r) {		
		String xmlRes = r.accept(MediaType.APPLICATION_XML).get(String.class);
		System.out.println(xmlRes);	
		
	}
	
	public static void getOneContact(WebResource r, String id) {
		GenericType<JAXBElement<Contact>> generic = new GenericType<JAXBElement<Contact>>() {};
		JAXBElement<Contact> jaxbContact = r.path(id).accept(MediaType.APPLICATION_XML).get(generic);
		Contact contact = jaxbContact.getValue();
		System.out.println(contact.getId() + ": " + contact.getName());
	}
	
	public static void postForm(WebResource r, String id, String name,String address,String phone) {
		Form form = new Form();
		form.add("id", id);
		form.add("name", name);
		form.add("address", address);
		form.add("phone", phone);
		ClientResponse response = r.type(MediaType.APPLICATION_FORM_URLENCODED)
								   .post(ClientResponse.class, form);
		System.out.println(response.getEntity(String.class));
	}
	
	public static void putOneContact(WebResource r, Contact c) {
		ClientResponse response = r.path(c.getId()).accept(MediaType.APPLICATION_XML)
								   .put(ClientResponse.class, c);
		System.out.println(response.getStatus());
	}
	
	public static void deleteOneContact(WebResource r, String id) {
		ClientResponse response = r.path(id).delete(ClientResponse.class);
		System.out.println(response.getStatus());
	}
}
