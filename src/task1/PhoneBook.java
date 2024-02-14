package task1;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PhoneBook {
    private Set<Contact> phoneBook;

    public PhoneBook() {
        this.phoneBook = new HashSet<>();
    }

    public void addContact(Contact contact) {
        if (!phoneBook.contains(contact)) {
            phoneBook.add(contact);
            System.out.println("Contact: " + contact + " added!");
        } else {
            System.out.println("This contact already have.");
        }

    }

    public void getAll(){
        if (phoneBook.isEmpty()) {
            System.out.println("В телефонной книге нет ни одного контакта.");
        }
        for (Contact contact : phoneBook) {
            System.out.println(contact);
        }
    }

    public void getContactByName(String name) {
        boolean result = false;
        for (Contact contact : phoneBook) {
            if(name.equals(contact.getName())){
                System.out.println(contact);
                result = true;
            }
            if (!result) {
                System.out.println("Contact with name: " + name + " not found.");
            }
        }
    }

    public void getContactByPhone(String phone){
        boolean result = false;
        for (Contact contact : phoneBook) {
            Map<String, String> numbers = contact.getPhoneNumbers();
            for(Map.Entry entry : numbers.entrySet()){
                if(phone.equals(entry.getKey())){
                    System.out.println(contact);
                    result = true;
                }
            }
        }
        if (!result) {
            System.out.println("Contact with phone: " + phone + " not found.");
        }
    }
}
