package arrays.mobilePhoneChallenge.CodingExercise;

import java.util.ArrayList;

public class MobilePhone {

    private static ArrayList<Contact> myContacts;
    private static String myNumber;

    public MobilePhone(String myNumber){
        this.myContacts = new ArrayList<>();
        this.myNumber = myNumber;
    }

    public boolean addNewContact(Contact contact){
        if(findContact(contact) == -1){
            myContacts.add(contact);
            return true;
        }
        return false;
    }

    public boolean updateContact(Contact oldContact, Contact newContact){
        int position = findContact(oldContact);
        if(position != -1){
            myContacts.remove(position);
            myContacts.add(newContact);
            return true;
        }
        return false;
    }

    public boolean removeContact(Contact contact){
        int position = findContact(contact);
        if(position != -1){
            myContacts.remove(position);
            return true;
        }
        return false;
    }

    public Contact queryContact(String name){
        int position = findContact(name);
        if(position != -1){
            return myContacts.get(position);
        }
        return null;
    }

    public void printContacts(){
        System.out.println("Contact list:");
        for(int i=0; i<myContacts.size(); i++){
            System.out.println((i+1)+". "+myContacts.get(i).getName()+" -> "+myContacts.get(i).getPhoneNumber());
        }
    }

    private int findContact(Contact contact){
        if (myContacts.size() != 0) {
            for (int i = 0; i < myContacts.size(); i++) {
                if (contact.getName().equals(myContacts.get(i).getName())) {
                    return i;
                }
            }
            return -1;
        } else {
            return -1;
        }
    }

    private int findContact(String name){
        if (myContacts.size() != 0) {
            for (int i = 0; i < myContacts.size(); i++) {
                if (name.equals(myContacts.get(i).getName())) {
                    return i;
                }
            }
            return -1;
        }else{
            return -1;
        }
    }
}
