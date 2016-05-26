package com.contacts.impl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.PathParam;


import com.contact.bean.Contact;
import com.contact.interfaces.ContactInterface;
import com.contact.storage.ContactStore;

public class ContactImpl implements ContactInterface {		
	
	
	public void storeContact(String id, String name, String address,  String phone){	
	Contact c = new Contact(id, name, address, phone);
	ContactStore.getStore().put(id, c);
	}
	
	public List<Contact> getAllContactsResult() {
		List<Contact> contacts = new ArrayList<Contact>();
		contacts.addAll(ContactStore.getStore().values());
		return contacts;
	}
	
	public Contact getOneContact(String contact) {
		Contact cont = null;
		for (Contact key : ContactStore.getStore().values()) {
			if (key.getName().contains(contact)) {
				cont = ContactStore.getStore().get(key.getId());
			}
		}
		if (cont == null) {
			// do something
		}
		return cont;
	}
	
	public boolean deleteOneContact(@PathParam("contact") String contact) {
		boolean deleted = false;
		Contact tobeRemoved=null;
		for (Contact key : ContactStore.getStore().values()) {
			if (key.getName().contains(contact)) {				
				 tobeRemoved=key;
				deleted = true;
			}
		}
		if(deleted)
		ContactStore.getStore().remove(tobeRemoved.getId());
		return deleted;

	}
	
	public static Map<String,String> parse(String paramString) {
		Map<String,String> params = new HashMap<String,String>();
		String[] paramPairs = paramString.split("&");
		for(String param : paramPairs) {
			String[] key_value = param.split("=");
			params.put(key_value[0], key_value[1]);
		}
		return params;
	}
	
	
	public boolean putContact(String id, String name, String address,String  phone) {
		boolean res;
		Contact c = new Contact(id,name,address,phone);
		 res=putAndGetResponse(c);
		 return res;
	}
	
	private boolean putAndGetResponse(Contact c) {
		boolean flag;
		if(ContactStore.getStore().containsKey(c.getId())) {
			flag = true;
		} else {
			flag = false;			
		}
		ContactStore.getStore().put(c.getId(), c);
		return flag;
	}
}
