package com.bridgelabz.addressbook;

public class AddressBook {
	String name;
	Contact[] persons;

	public AddressBook(String addressBookName, Contact[] persons) {
		super();
		this.name = addressBookName;
		this.persons = persons;
	}

}