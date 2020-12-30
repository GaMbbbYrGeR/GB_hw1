package GeekBrains.Level2.Lesson3.Homework;

import java.util.HashMap;

public class Task3 {
    public static void main(String[] args) {
        String[] words = {"a", "a", "a", "b", "c", "d", "d", "e", "e", "f", "g", "h"};

        HashMap<String, Integer> hashMap = new HashMap<>();
        for(String x : words) {
            hashMap.put(x, hashMap.getOrDefault(x, 0) + 1);
        }
        System.out.println(hashMap);

        TelephoneBook book = new TelephoneBook();
        book.add("Kirill", "89458652496");
        book.add("Vanya", "89458687496");
        book.add("Petya", "89458986496");
        book.add("Rita", "89458652136");
        book.add("Marina", "89496478496");

        System.out.println(book.get("Kirill"));
        System.out.println(book.get("Marina"));
        System.out.println(book.get("Petya"));

    }
}
