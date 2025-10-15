package org.example.mobile;

import java.util.Objects;

public class Contact {
    private final String name;
    private final String phoneNumber;

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() { return name; }

    public String getPhoneNumber() { return phoneNumber; }

    public static Contact createContact(String name, String phoneNumber) {
        return new Contact(name, phoneNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;                // aynı referanssa eşit
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        // Genelde testler case-sensitive karşılaştırır; o yüzden equals kullanıyoruz
        return Objects.equals(name, contact.name)
                && Objects.equals(phoneNumber, contact.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phoneNumber);
    }

    @Override
    public String toString() {
        return "Contact{name='" + name + "', phoneNumber='" + phoneNumber + "'}";
    }
}
