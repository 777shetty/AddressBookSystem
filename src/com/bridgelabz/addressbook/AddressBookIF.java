package com.bridgelabz.addressbook;



import java.util.HashMap;

public interface AddressBookIF {

	String getAddressBookName();

	HashMap<String, Contact> getContactList();
	void setContact(HashMap<String, String> map);

	void addContact();

	void editContact();

	void viewContact();

	void deleteContact();

	boolean isAddressBookEmpty();

	void openAddressBook();

	void sortedByName();

	void sortedByCity();

	void sortedByState();

	void sortedByZip();

}
