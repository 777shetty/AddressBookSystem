package com.bridgelabz.addressbook;

import java.util.Scanner;

public class AddressBookImpl<sc> implements AddressBookIF {

	Contact[] arrayOfContacts;
	AddressBook firstBook;
	int index;
	int numberOfElements;
	static final Scanner sc = AddressBookMain.sc;


	public AddressBookImpl(int maximumContacts) {

		super();
		this.arrayOfContacts = new Contact[maximumContacts];
		this.firstBook = new AddressBook(arrayOfContacts);
		this.index = -1;
		numberOfElements = 0;
	}

	@Override
	public void addContact() {

		if (numberOfElements == arrayOfContacts.length) {
			System.out.println("Maximum contacts taken, no space left!");
			return;
		}

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

		for (int i = 0; i < arrayOfContacts.length; i++) {

			index = (++index) % arrayOfContacts.length;

			if (firstBook.persons[index] == null) {
				break;
			}
		}
		arrayOfContacts[index] = new Contact(firstName, lastName, address, city, state, zip, phoneNum, email);
		numberOfElements++;
		System.out.println("Contact Details are added!\n" + firstBook.persons[index]);
	}

	@Override
	public void editContact() {

		
		boolean found = false;
		System.out.println("Enter first name of contact that you want to edit: ");
		String firstName = sc.nextLine();
		System.out.println("Enter last name of contact that you want to edit: ");
		String lastName = sc.nextLine();
		for (int i = 0; i < arrayOfContacts.length; i++) {

			if (firstBook.persons[i] != null && firstBook.persons[i].getFirstName().equals(firstName)
					&& firstBook.persons[i].getLastName().equals(lastName)) {
				found = true;
				System.out.println("Index: " + firstBook.persons[i]);
				System.out.println("Enter your choice: \n1.First Name \n2.Last Name \n3.Address \n4.City \n5.State "
						+ "\n6.Zip Code \n7.Phone Number \n8.EmailId \n9.Skip Editing");
				int choice = sc.nextInt();
				sc.nextLine();
				switch (choice) {
				case 1:
					System.out.println("Enter new First Name: ");
					String newFirstName = sc.nextLine();
					firstBook.persons[i].setFirstName(newFirstName);
					break;
				case 2:
					System.out.println("Enter new Last Name: ");
					String newLastName = sc.nextLine();
					firstBook.persons[i].setLastName(newLastName);
					break;
				case 3:
					System.out.println("Enter new Address: ");
					String newAddress = sc.nextLine();
					firstBook.persons[i].setAddress(newAddress);
					break;
				case 4:
					System.out.println("Enter new City: ");
					String newCity = sc.nextLine();
					firstBook.persons[i].setCity(newCity);
					break;
				case 5:
					System.out.println("Enter new State: ");
					String newState = sc.nextLine();
					firstBook.persons[i].setState(newState);
					break;
				case 6:
					System.out.println("Enter new ZipCode: ");
					int newZip = sc.nextInt();
					firstBook.persons[i].setZip(newZip);
					break;
				case 7:
					System.out.println("Enter new Phone Number: ");
					long newPhoneNum = sc.nextLong();
					firstBook.persons[i].setPhoneNumber(newPhoneNum);
					break;
				case 8:
					System.out.println("Enter new Email Id: ");
					String newEmail = sc.nextLine();
					firstBook.persons[i].setEmail(newEmail);
					break;
				case 9:
					break;
				default:
					System.out.println("Choose right choice!!");
				}
			}
		}
		if (!found) {
			System.out.println("No contact with such name exists!!");
		}
	}

	@Override
	public void viewContact() {

		for (int i = 0; i < arrayOfContacts.length; i++) {

			if (firstBook.persons[i] != null) {
				System.out.println(firstBook.persons[i]);
			}
		}
	}

	@Override
	public void deleteContact() {

		
		boolean found = false;
		System.out.println("Enter first name of contact that you want to delete: ");
		String firstName = sc.nextLine();
		System.out.println("Enter last name of contact that you want to delete: ");
		String lastName = sc.nextLine();
		for (int i = 0; i < arrayOfContacts.length; i++) {

			if (firstBook.persons[i] != null && firstBook.persons[i].getFirstName().equals(firstName)
					&& firstBook.persons[i].getLastName().equals(lastName)) {
				found = true;
				System.out.println("Index: " + firstBook.persons[i] + "\nDelete (y/n)");
				if ((sc.nextLine()).equals("y")) {
					firstBook.persons[i] = null;
					numberOfElements--;
					System.out.println("Contact is deleted!");
				}
			}
		}
		if (!found) {

			System.out.println("No contact with such name exists!!");
		}

	}

	@Override
	public boolean isAddressBookEmpty() {
		if (numberOfElements == 0) {

			System.out.println("Address Book is empty!");
			return true;
		} 
		else {

			return false;
		}
	}
}