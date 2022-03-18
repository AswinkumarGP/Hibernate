package arrays.mobilePhoneChallenge;

import java.util.ArrayList;
import java.util.Scanner;

public class MobilePhoneChallenge {

    private static ArrayList<Contact> contactArrayList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        viewOptions();
        boolean flag = true;
        while(flag){
            System.out.println("Enter the option : ");
            int input = scanner.nextInt();
            switch(input){
                case 0:
                    viewOptions();
                    break;
                case 1:
                    flag = false;
                    break;
                case 2:
                    listOfContacts();
                    break;
                case 3:
                    addContact();
                    break;
                case 4:
                    updateContact();
                    break;
                case 5:
                    removeContact();
                    break;
                case 6:
                    findContact();
                    break;
                default:
                    System.out.println("Invalid option !!");
                    flag = false;
            }
        }
    }

    private static void viewOptions(){
        System.out.println("0. Available options");
        System.out.println("1. Quit");
        System.out.println("2. List of contacts");
        System.out.println("3. Add new contact");
        System.out.println("4. Update existing contact");
        System.out.println("5. Remove contact");
        System.out.println("6. Search/Find contact");
    }

    private static void listOfContacts(){
        System.out.println("List of contacts");
        Contact.print(contactArrayList);
    }

    private static boolean addContact(){
        System.out.println("Add new contact :");
        System.out.println("Enter name");
        String name = scanner.next();
        System.out.println("Enter phone number");
        String phoneNumber = scanner.next();
        return Contact.add(contactArrayList, name, phoneNumber);
    }

    private static boolean updateContact(){
        System.out.println("Update existing contact :");
        System.out.println("Enter name");
        String name = scanner.next();
        System.out.println("Enter phone number");
        String phoneNumber = scanner.next();
        return Contact.update(contactArrayList, name, phoneNumber);
    }

    private static boolean removeContact(){
        System.out.println("Delete existing contact :");
        System.out.println("Enter name");
        String name = scanner.next();
        return Contact.delete(contactArrayList, name);
    }

    private static boolean findContact(){
        System.out.println("Find contact :");
        System.out.println("Enter name");
        String name = scanner.next();
        if (Contact.find(contactArrayList, name) >= 0){
            System.out.println("Contact found!!");
            return true;
        } else {
            System.out.println("Contact not found");
            return false;
        }
    }
}
