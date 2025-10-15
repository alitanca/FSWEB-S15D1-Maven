package org.example.mobile;

import java.util.ArrayList;
import java.util.List;

public class MobilePhone {

    private final String myNumber;
    private final ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber, List<Contact> contacts) {
        this.myNumber = myNumber;
        if (contacts != null) {
            this.myContacts = new ArrayList<>(contacts);
        } else {
            this.myContacts = new ArrayList<>();
        }
    }

    public MobilePhone(String myNumber) {
        this(myNumber, new ArrayList<>());
    }

    public String getMyNumber() {
        return myNumber;
    }

    public ArrayList<Contact> getMyContacts() {
        return myContacts;
    }

    public boolean addNewContact(Contact contact) {
        if (contact == null) return false;
        if (findContact(contact.getName()) >= 0) {
            return false;
        }
        myContacts.add(contact);
        return true;
    }

    public boolean updateContact(Contact oldContact, Contact newContact) {
        if (oldContact == null || newContact == null) return false;
        int oldIndex = findContact(oldContact);
        if (oldIndex < 0) return false;

        int duplicateCheck = findContact(newContact.getName());
        if (duplicateCheck >= 0 && duplicateCheck != oldIndex) {
            return false;
        }
        myContacts.set(oldIndex, newContact);
        return true;
    }

    public boolean removeContact(Contact contact) {
        int index = findContact(contact);
        if (index < 0) return false;
        myContacts.remove(index);
        return true;
    }

    public int findContact(Contact contact) {
        if (contact == null) return -1;
        for (int i = 0; i < myContacts.size(); i++) {
            Contact c = myContacts.get(i);
            if (c.getName().equalsIgnoreCase(contact.getName())
                    && c.getPhoneNumber().equals(contact.getPhoneNumber())) {
                return i;
            }
        }
        return -1;
    }

    public int findContact(String name) {
        if (name == null) return -1;
        for (int i = 0; i < myContacts.size(); i++) {
            if (myContacts.get(i).getName().equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }

    public Contact queryContact(String name) {
        int idx = findContact(name);
        return (idx >= 0) ? myContacts.get(idx) : null;
    }

    public void printContacts() {
        System.out.println("Contact List:");
        for (Contact c : myContacts) {
            System.out.println(c.getName() + " -> " + c.getPhoneNumber());
        }
    }
}
