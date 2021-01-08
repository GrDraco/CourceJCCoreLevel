package homework.lesson_3;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Phonebook {
    private ArrayList<Contact> phones;

    public void add(String secondName, String phone) {
        if (phones == null)
            phones = new ArrayList();
        phones.add(new Contact(secondName, phone));
    }

    public ArrayList<Contact> get(String secondName) {
        if (phones == null)
            return new ArrayList();
        return Contact.getArrayList(phones.stream().filter(phone -> phone.secondName == secondName));
    }
}
