package com.contact.rest;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.contact.bean.Contact;
import com.contacts.impl.ContactImpl;

@Path("/contacts")
public class ContactsService {

	@Context
	UriInfo uriInfo;
	@Context
	Request request;
	ContactImpl conImpl = new ContactImpl();

	/*
	 * Method to get all contacts from the Store 
	 * Url_path=http://localhost:8080/restContact/rest/contacts
	 */

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Contact> getContacts() {
		return conImpl.getAllContactsResult();
	}

	/*
	 * Method to get one contact from the Store 
	 *  Url_path=http://localhost:8080/restContact/rest/contacts/contact/{contactname}
	 */

	@GET
	@Path("contact/{contact}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Contact getContact(@PathParam("contact") String contact) {
		return conImpl.getOneContact(contact);
	}

	/*
	 * Method to add a contact to the Store 
	 *  Url_path=http://localhost:8080/restContact/rest/contacts/add
	 */

	@POST
	@Path("add")
	@Produces(MediaType.TEXT_HTML)
	@Consumes({ MediaType.APPLICATION_FORM_URLENCODED, MediaType.APPLICATION_XML })
	public Response addUser(

			@FormParam("id") String id, @FormParam("name") String name, @FormParam("address") String address,
			@FormParam("phone") String phone, @Context HttpServletResponse servletResponse) throws IOException {

		conImpl.storeContact(id, name, address, phone);
		return Response.status(200).entity("Contact  with name : " + name + ", id : " + id + " , address : " + address
				+ " , and phone : " + phone + " is added into the Store.").build();

	}
	/*
	 * Method to delete a contact from the Store Url
	 *  Url_path=http://localhost:8080/restContact/rest/contacts/contact/delete/{contactname}
	 */

	@DELETE
	@Produces(MediaType.TEXT_HTML)
	@Path("contact/delete/{contact}")
	public Response deleteContact(@PathParam("contact") String contact) {
		boolean deleted = conImpl.deleteOneContact(contact);
		if (deleted)
			return Response.status(200).entity("Contact  with name " + contact + " is deleted ").build();
		else
			return Response.status(200).entity("Contact not present in the Store ").build();

	}
	
	@PUT
	@Path("modify")
	@Produces(MediaType.TEXT_HTML)
	@Consumes({ MediaType.APPLICATION_FORM_URLENCODED, MediaType.APPLICATION_XML })
	public Response modifyUser(

			@FormParam("id") String id, @FormParam("name") String name, @FormParam("address") String address,
			@FormParam("phone") String phone, @Context HttpServletResponse servletResponse) throws IOException {

		boolean res=conImpl.putContact(id, name, address, phone);
		if(res)			
		return Response.status(200).entity("Contact  with name : " + name + ", id : " + id + " , address : " + address
				+ " , and phone : " + phone + " is modified in the Store.").build();
		else
			return Response.status(200).entity("Contact not present in the Store ").build();
			

	}
}
