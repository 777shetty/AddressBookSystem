package com.bridgelabz.addressbook;

import java.util.HashMap;

public class AddressBook {
	String name;
	HashMap<String, Contact> contactList;

	public AddressBook(String addressBookName, HashMap<String, Contact> contactList) {
		super();
		this.name = addressBookName;
		this.contactList = contactList;
		
	}

}