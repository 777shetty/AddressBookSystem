package com.bridgelabz.addressbook;

import java.util.Scanner;

public class AddressBookMain {

	public static final int MAX_ADDRESS_BOOKS = 5;
	public static final Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("Welcome to Address Book Program\n");
		int choice, addressBookNumber = -1;
		AddressBookIF addressBook[] = new AddressBookImpl[MAX_ADDRESS_BOOKS];

		do {
			System.out.println("\n1.Create new Address Book \n2.Open Address Book \n3.Books List \n4.Exit");
			choice = sc.nextInt();
			sc.nextLine();
			switch (choice) {
			
			case 1:
				if (addressBookNumber < 4) {
					
					System.out.print("Enter the address book name: ");
					String addressBookName = sc.nextLine();
					System.out.print("Enter the maximum number of contacts required: ");
					addressBook[++addressBookNumber] = new AddressBookImpl(addressBookName, sc.nextInt());
				} 
				else {
					
					System.out.println("Maximum address books are already created!");
				}
				break;
				
			case 2:
				System.out.print("Enter the address book name: ");
				String name = sc.nextLine();
				boolean found = false;
				for (int i = 0; i <= addressBookNumber; i++) {
					
					if (addressBook[i].getAddressBookName().equals(name)) {
						
						found = true;
						addressBook[i].openAddressbook();
						break;
					}
				}
				if(!found) {
					System.out.println("No book with such name exists!\n");
				}
				break;
				
			case 3:
				if(addressBookNumber == -1) {
					System.out.println("No address books are created yet!");
				}
				for (int i = 0; i <= addressBookNumber; i++) {
					System.out.println((i+1)+". "+addressBook[i].getAddressBookName());
				}
				
			case 4:
				break;
				
			default:
				System.out.println("Choose correct option from above mentioned option only!!");
				break;
			}
		} while (choice != 4);
		sc.close();
	}
}


