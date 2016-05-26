package com.contact.storage;

import java.util.HashMap;
import java.util.Map;

import com.contact.bean.Contact;



public class ContactStore {
	private static Map<String,Contact> store;
	private static ContactStore instance = null;
	
	private ContactStore() {
		store = new HashMap<String,Contact>();
		initOneContact();
	}
	
	public static Map<String,Contact> getStore() {
		if(instance==null) {
			instance = new ContactStore();
		}
		return store;
	}
	
	
	/*
	 * Method to input values to the Store 
	 *  Initially values are inserted into the store for testing purpose
	 */
	private static void initOneContact() {
	
		Contact contact1 = new Contact("first", "Jhon","Antibes Area", "80986543");
		store.put(contact1.getId(), contact1);
		Contact contact2 = new Contact("second", "Martin","Beach Area","80986541");
		store.put(contact2.getId(), contact2);
		Contact contact3 = new Contact("third", "Zen","Valbonne Area","80986540");
		store.put(contact3.getId(), contact3);
		Contact contact4 = new Contact("four", "Kate","Anthea Area","80986544");
		store.put(contact4.getId(), contact4);
		Contact contact5 = new Contact("five", "Rome","Juan les Pins Area","80986545");
		store.put(contact5.getId(), contact5);
	}
}
