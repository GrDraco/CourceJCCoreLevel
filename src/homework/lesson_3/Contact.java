package homework.lesson_3;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Contact implements Comparable {
    public static ArrayList<Contact> getArrayList(Stream<Contact> stream)
    {
        return stream.collect(Collectors.toCollection(ArrayList::new));
    }

    public String secondName;
    public String phone;

    public Contact(String secondName, String phone) {
        this.secondName = secondName;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return phone;
    }

    @Override
    public int compareTo(Object o) {
        return this.secondName.compareTo(((Contact) o).secondName);
    }
}
