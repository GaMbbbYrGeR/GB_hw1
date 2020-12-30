package GeekBrains.Level2.Lesson3.Homework;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class TelephoneBook {
    private HashMap<String, Set<String>> phoneNumbersBook = new HashMap<>();

    public void add(String name, String phone) {
        Set<String> number = phoneNumbersBook.getOrDefault(name, new HashSet<>());
        number.add(phone);
        phoneNumbersBook.put(name, number);
    }

    public Set<String> get(String name) {
        return phoneNumbersBook.get(name);
    }
}
