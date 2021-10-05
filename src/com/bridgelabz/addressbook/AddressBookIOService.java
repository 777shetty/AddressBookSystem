package com.bridgelabz.addressbook;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AddressBookIOService {
    private static final String filePath = "/home/rajatsp/bridgelabz/day24/assignment/AddressBookSystem/";

    public static void WriteContactsToFile(HashMap<String, Contact> contactList, String addressBookName) {
        try {

            Path playPath = Paths.get(filePath + "Address_Books/");
            if (Files.notExists(playPath)) {
                Files.createDirectory(playPath);
            }
            Path tempFile = Paths.get(playPath + "/" + addressBookName);

            StringBuffer empBuffer = new StringBuffer();
            contactList.forEach((name, contact) -> {
                String employeeDataString = contact.toString().concat("\n");
                empBuffer.append(employeeDataString);
            });

            Files.write(Paths.get(String.valueOf(tempFile)), empBuffer.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void readData(List<AddressBookIF> addressBook) {
        try {
            Path playPath = Paths.get(filePath + "Address_Books/");
            if (Files.exists(playPath)) {
                File[] listOfFiles = playPath.toFile().listFiles();
                for (File file : listOfFiles) {

                    String addressBookName = file.getName();
                    AddressBookIF newAddressBook = new AddressBookImpl(addressBookName);
                    addressBook.add(newAddressBook);
                    HashMap<String, String> map = new HashMap<>();
                    Files.lines(new File(filePath + "Address_Books/" + addressBookName).toPath()).map(line -> line.trim()).forEach(line -> {
                        String[] attributes = {"First Name", "Last Name", "Address", "City", "State", "Zip Code", "Phone Number", "Email Id"};
                        String[] attributeValues = line.split("[|]");
                        for (int i = 0; i < attributes.length; i++) {
                            map.put(attributes[i], attributeValues[i].split("=")[1]);
                        }
                        newAddressBook.setContact(map);
                    });
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}