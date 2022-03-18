package arrays.mobilePhoneChallenge;

import java.util.ArrayList;

public class Contact {

    public String name;
    public String phoneNumber;

    public Contact(){};

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public static void print(ArrayList<Contact> contactArrayList){
        for(Contact contact : contactArrayList){
            System.out.println(contact.getName()+" - "+contact.getPhoneNumber());
        }
    }

    public static int find(ArrayList<Contact> contactArrayList, String name){
        for(int i=0; i<contactArrayList.size(); i++){
            if (contactArrayList.get(i).getName().equalsIgnoreCase(name)){
                return i;
            }
        }
        return -1;
    }

    public static boolean add(ArrayList<Contact> contactArrayList, String name, String phoneNumber){
        if (Contact.find(contactArrayList, name) >= 0){
            System.out.println("Contact exists");
            return false;
        }
        Contact contact = new Contact(name, phoneNumber);
        contactArrayList.add(contact);
        System.out.println("Contact added");
        return true;
    }

    public static boolean update(ArrayList<Contact> contactArrayList, String name, String phoneNumber){
        int findPosition = Contact.find(contactArrayList, name);
        if (findPosition >= 0){
            contactArrayList.get(findPosition).setPhoneNumber(phoneNumber);
            System.out.println("Contact updated");
            return true;
        }
        System.out.println("Contact not found");
        return false;
    }

    public static boolean delete(ArrayList<Contact> contactArrayList, String name){
        int findPosition = Contact.find(contactArrayList, name);
        if (findPosition >= 0){
            contactArrayList.remove(findPosition);
            System.out.println("Contact deleted");
            return true;

        }
        System.out.println("Contact not found");
        return false;
    }


}
