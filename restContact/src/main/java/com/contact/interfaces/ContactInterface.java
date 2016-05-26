package com.contact.interfaces;

import java.util.List;

import com.contact.bean.Contact;

public interface ContactInterface {
	
	public void storeContact(String id, String name, String address,  String phone);
	public List<Contact> getAllContactsResult();
	public Contact getOneContact(String contact);
	public boolean deleteOneContact(String contact);

}
