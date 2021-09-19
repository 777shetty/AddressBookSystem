package com.bridgelabz.addressbook;



public interface AddressBookIF {

	public String getAddressBookName();
	
	public void addContact();

	public void editContact();

	public void viewContact();

	public void deleteContact();

	public boolean isAddressBookEmpty();

	public void openAddressbook();
}