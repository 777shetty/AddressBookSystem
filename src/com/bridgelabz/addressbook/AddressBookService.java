package com.bridgelabz.addressbook;


import java.util.Scanner;

public class AddressBookService {
//	public void create
//	AddressBook firstBook = new AddressBook(null)
	static AddressBook firstBook;

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
		firstBook = new AddressBook(contact);
		System.out.println("Contact Details are added!\n" + firstBook.person);
	}

	public void editContact() {
		if( firstBook==null) {
			System.out.println("Address Book is empty!");
			return;
		}
		Scanner sc = AddressBookMain.sc;
		System.out.println("Enter first name of contact that you want to edit: ");
		String firstName = sc.nextLine();
		if (firstBook.person.getFirstName().equals(firstName)) {
			System.out.println("Index: " + firstBook.person);
			System.out.println("Enter your choice: \n1.First Name \n2.Last Name \n3.Address \n4.City \n5.State "
					+ "\n6.Zip Code \n7.Phone Number \n8.EmailId \n9.Skip Editing");
			int choice = sc.nextInt();
			sc.nextLine();
			switch (choice) {
			case 1:
				System.out.println("Enter new First Name: ");
				String newFirstName = sc.nextLine();
				firstBook.person.setFirstName(newFirstName);
				break;
			case 2:
				System.out.println("Enter new Last Name: ");
				String newLastName = sc.nextLine();
				firstBook.person.setLastName(newLastName);
				break;
			case 3:
				System.out.println("Enter new Address: ");
				String newAddress = sc.nextLine();
				firstBook.person.setAddress(newAddress);
				break;
			case 4:
				System.out.println("Enter new City: ");
				String newCity = sc.nextLine();
				firstBook.person.setCity(newCity);
				break;
			case 5:
				System.out.println("Enter new State: ");
				String newState = sc.nextLine();
				firstBook.person.setState(newState);
				break;
			case 6:
				System.out.println("Enter new ZipCode: ");
				int newZip = sc.nextInt();
				firstBook.person.setZip(newZip);
				break;
			case 7:
				System.out.println("Enter new Phone Number: ");
				long newPhoneNum = sc.nextLong();
				firstBook.person.setPhoneNumber(newPhoneNum);
				break;
			case 8:
				System.out.println("Enter new Email Id: ");
				String newEmail = sc.nextLine();
				firstBook.person.setEmail(newEmail);
				break;
			case 9:
				break;
			default:
				System.out.println("Choose right choice!!");
			}
		} else {
			System.out.println("No contact with such phone number exists!!");
		}
	}

	public void viewContact() {
		if( firstBook==null) {
			System.out.println("Address Book is empty!");
			return;
		}
		System.out.println(firstBook.person);
	}
}
