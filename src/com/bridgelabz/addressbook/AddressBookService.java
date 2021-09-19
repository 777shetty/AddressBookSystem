package com.bridgelabz.addressbook;

import java.util.Scanner;


public class AddressBookService {
//	public void create
//	AddressBook firstBook = new AddressBook(null)
	
	public void addContact() {
		Scanner sc = AddressBookMain.sc;
		System.out.println("Enter First Name: ");
		String firstName = sc.nextLine();
		System.out.println("Enter Last Name: ");
		String lastName = sc.nextLine();
		System.out.println("Enter your Address: ");
		String address = sc.nextLine();
		System.out.println("Enter your City: ");
		String city = sc.nextLine();
		System.out.println("Enter your State: ");
		String state = sc.nextLine();
		System.out.println("Enter your Zip Code: ");
		int zip = sc.nextInt();
		System.out.println("Enter your Phone Number: ");
		long phoneNum = sc.nextLong();
		sc.nextLine();
		System.out.println("Enter your email Id: ");
		String email = sc.nextLine();

		Contact contact = new Contact(firstName, lastName, address, city, state, zip, phoneNum, email);
		AddressBook firstBook = new AddressBook(contact);
		System.out.println("Contact Details are added!\n"+firstBook.person);
	}
}