package homework.lesson_3;

import java.util.*;

public class Main {
    private static final String FORMAT_RESULT = "%s: %s";
    private static final String WORD_UNIQUE = "Уникальные слова";
    private static final String WORD_COUNT = "Кол-во встречающиеся слов";
    private static final String FOUND_CONTACTS = "Найдены контакты";

    public static void main(String[] args) {
        String[] words = {
                "Class",
                "Array",
                "Hash",
                "Return",
                "Return",
                "Public",
                "Private",
                "Protected",
                "Function",
                "String",
                "String",
                "String",
                "Static"
        };
        System.out.println("---------------Task_1---------------");
        System.out.println(String.format(FORMAT_RESULT, WORD_UNIQUE, getListUnique(words)));
        System.out.println(String.format(FORMAT_RESULT, WORD_COUNT, getWordCount(words)));
        System.out.println("---------------Task_2---------------");
        Phonebook phonebook= new Phonebook();
        phonebook.add("Титов", "89632652020");
        phonebook.add("Сидоров", "89129751213");
        phonebook.add("Титов", "89632652025");
        System.out.println(String.format(FORMAT_RESULT, FOUND_CONTACTS, phonebook.get("Титов")));
    }

    private static ArrayList<String> getListUnique(String[] words) {
        ArrayList<String> unique = new ArrayList();
        if (words == null || words.length == 0)
            return unique;
        HashSet<String> recurring = new HashSet();
        Arrays.stream(words).forEach(word -> {
            if (unique.contains(word)) {
                recurring.add(word);
                unique.remove(word);
            }
            else if (!recurring.contains(word))
                unique.add(word);
        });
        return unique;
    }

    private static HashMap<String, Integer> getWordCount(String[] words) {
        HashMap<String, Integer> duplicateCount = new HashMap();
        if (words == null || words.length == 0)
            return duplicateCount;
        Arrays.stream(words).forEach(word -> {
            if (duplicateCount.containsKey(word))
                duplicateCount.put(word, duplicateCount.get(word) + 1);
            else
                duplicateCount.put(word, 1);
        });
        return duplicateCount;
    }
}
