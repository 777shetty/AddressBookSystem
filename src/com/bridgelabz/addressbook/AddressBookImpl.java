package com.bridgelabz.addressbook;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class AddressBookImpl implements AddressBookIF {

	AddressBook addressBook;
	int index;
	static final Scanner sc = AddressBookMain.sc;
	static final HashMap<String, List<Contact>> contactNamesByCity = AddressBookMain.contactNamesByCity;
	static final HashMap<String, List<Contact>> contactNamesByState = AddressBookMain.contactNamesByState;

	public AddressBookImpl(String addressBookName) {

		super();
		this.addressBook = new AddressBook(addressBookName, new HashMap<String, Contact>());
		this.index = -1;
	}

	@Override
	public String getAddressBookName() {
		return addressBook.name;
	}

	@Override
	public void addContact() {

		System.out.println("Enter First Name: ");
		String firstName = sc.nextLine();
		System.out.println("Enter Last Name: ");
		String lastName = sc.nextLine();

		if (addressBook.contactList.get(firstName + " " + lastName) != null) {
			System.out.println("Duplicate entry! Contact already exists");
		} else {
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
			addressBook.contactList.put(firstName + " " + lastName,
					new Contact(firstName, lastName, address, city, state, zip, phoneNum, email));
			if (contactNamesByCity.get(city) == null) {
				contactNamesByCity.put(city, new LinkedList<Contact>());
			}
			contactNamesByCity.get(city).add(addressBook.contactList.get(firstName + " " + lastName));

			if (contactNamesByState.get(state) == null) {
				contactNamesByState.put(state, new LinkedList<Contact>());
			}
			contactNamesByState.get(state).add(addressBook.contactList.get(firstName + " " + lastName));

			System.out
					.println("Contact Details are added!\n" + addressBook.contactList.get(firstName + " " + lastName));
		}
	}

	@Override
	public void editContact() {

		System.out.println("Enter first name of contact that you want to edit: ");
		String firstName = sc.nextLine();
		System.out.println("Enter last name of contact that you want to edit: ");
		String lastName = sc.nextLine();
		String name = firstName + " " + lastName;
		Contact contact = addressBook.contactList.get(name);
		if (contact != null) {
			System.out.println("Enter your choice: \n1.First Name \n2.Last Name \n3.Address \n4.City \n5.State "
					+ "\n6.Zip Code \n7.Phone Number \n8.EmailId \n9.Skip Editing");
			int choice = sc.nextInt();
			sc.nextLine();
			switch (choice) {
			case 1:
				System.out.println("Enter new First Name: ");
				String newFirstName = sc.nextLine();
				if (addressBook.contactList.get(newFirstName + " " + lastName) != null) {
					System.out.println("Duplicate entry! Contact already exists");
				} else {
					addressBook.contactList.remove(name);

					addressBook.contactList.put(newFirstName + " " + lastName,
							new Contact(newFirstName, lastName, contact.getAddress(), contact.getCity(),
									contact.getState(), contact.getZip(), contact.getPhoneNumber(),
									contact.getEmail()));
					System.out.println("Contact Details are added!\n"
							+ addressBook.contactList.get(newFirstName + " " + lastName));
				}

				break;
			case 2:
				System.out.println("Enter new Last Name: ");
				String newLastName = sc.nextLine();
				if (addressBook.contactList.get(firstName + " " + newLastName) != null) {
					System.out.println("Duplicate entry! Contact already exists");
				} else {
					addressBook.contactList.remove(name);
					addressBook.contactList.put(firstName + " " + newLastName,
							new Contact(firstName, newLastName, contact.getAddress(), contact.getCity(),
									contact.getState(), contact.getZip(), contact.getPhoneNumber(),
									contact.getEmail()));
					System.out.println("Contact Details are added!\n"
							+ addressBook.contactList.get(firstName + " " + newLastName));
				}
				break;
			case 3:
				System.out.println("Enter new Address: ");
				String newAddress = sc.nextLine();
				contact.setAddress(newAddress);
				break;
			case 4:
				System.out.println("Enter new City: ");
				String newCity = sc.nextLine();
				contactNamesByCity.get(contact.getCity()).remove(contact);
				contact.setCity(newCity);
				contactNamesByCity.get(contact.getCity()).add(contact);
				break;
			case 5:
				System.out.println("Enter new State: ");
				String newState = sc.nextLine();
				contactNamesByState.get(contact.getState()).remove(contact);
				contact.setState(newState);
				contactNamesByState.get(contact.getState()).add(contact);

				break;
			case 6:
				System.out.println("Enter new ZipCode: ");
				int newZip = sc.nextInt();
				contact.setZip(newZip);
				break;
			case 7:
				System.out.println("Enter new Phone Number: ");
				long newPhoneNum = sc.nextLong();
				contact.setPhoneNumber(newPhoneNum);
				break;
			case 8:
				System.out.println("Enter new Email Id: ");
				String newEmail = sc.nextLine();
				contact.setEmail(newEmail);
				break;
			case 9:
				break;
			default:
				System.out.println("Choose right choice!!");
			}
		} else {
			System.out.println("No contact with such name exists!");
		}

	}

	@Override
	public void viewContact() {

		for (Contact contact : addressBook.contactList.values()) {
			System.out.println(contact);
		}
	}

	@Override
	public void deleteContact() {

		System.out.println("Enter first name of contact that you want to edit: ");
		String firstName = sc.nextLine();
		System.out.println("Enter last name of contact that you want to edit: ");
		String lastName = sc.nextLine();
		Contact contact = addressBook.contactList.get(firstName + " " + lastName);
		if (contact != null) {
			System.out.println(contact + "\nDelete (y/n)");
			if ((sc.nextLine()).equals("y")) {

				addressBook.contactList.remove(firstName + " " + lastName);
				contactNamesByCity.get(contact.getCity()).remove(contact);
				contactNamesByState.get(contact.getState()).remove(contact);

				System.out.println("Contact is deleted!");
			}
		} else {
			System.out.println("No contact with such name exists!");
		}
	}

	@Override
	public boolean isAddressBookEmpty() {
		if (addressBook.contactList.isEmpty()) {

			System.out.println("Address Book is empty!");
			return true;
		} else {

			return false;
		}
	}

	public void openAddressbook() {
		int choice;
		do {
			System.out.println(
					"1.Add Contact \n2.View Contact \n3.Edit Contact \n4.Delete Contact \n5.Exit from the AddressBook");
			choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {

			case 1:
				this.addContact();
				break;

			case 2:
				if (!this.isAddressBookEmpty()) {

					this.viewContact();
				}
				break;

			case 3:
				if (!this.isAddressBookEmpty()) {

					this.editContact();
				}
				break;

			case 4:
				if (!this.isAddressBookEmpty()) {

					this.deleteContact();
				}
				break;

			case 5:
				break;

			default:
				System.out.println("Choose correct option from above mentioned option only!!");
				break;
			}
		} while (choice != 5);

	}
}
