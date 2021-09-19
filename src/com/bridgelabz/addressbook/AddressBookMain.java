package com.bridgelabz.addressbook;
import java.util.Scanner;

public class AddressBookMain {
	static AddressBookService addressBook = new AddressBookService();
	public static final Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("Welcome to Address Book Program");
		int choice;
		System.out.println("1.Add Contact \n2.Exit");
		choice = sc.nextInt();
		sc.nextLine();
		switch (choice) {
		case 1:
			addressBook.addContact();
			break;
		default:
			System.out.println("Choose correct option from above mentioned option only!!");
			break;
		}
		sc.close();
	}
}
