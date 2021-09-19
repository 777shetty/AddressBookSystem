package com.bridgelabz.addressbook;
import java.util.Scanner;


public class AddressBookMain {

	public static final Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("Welcome to Address Book Program\n");
		int choice;
		System.out.print("Enter the maximum number of contacts required: ");
		AddressBookIF addressBook = new AddressBookImpl(sc.nextInt());
		do {
			System.out.println("1.Add Contact \n2.View Contact \n3.Edit Contact \n4.Delete Contact \n5.Exit");
			choice = sc.nextInt();
			sc.nextLine();
			switch (choice) {
			case 1:
				addressBook.addContact();
				break;
			case 2:
				if(!addressBook.isAddressBookEmpty()) {
					
				addressBook.viewContact();
				}
				break;
			case 3:
				if(!addressBook.isAddressBookEmpty()) {

				addressBook.editContact();
				}
				break;
			case 4:
				if(!addressBook.isAddressBookEmpty()) {

				addressBook.deleteContact();
				}
				break;
			case 5:
				break;
			default:
				System.out.println("Choose correct option from above mentioned option only!!");
				break;
			}
		}while(choice!=5);
		sc.close();
}
	}

