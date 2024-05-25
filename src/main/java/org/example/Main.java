package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> books = new ArrayList<>(List.of("Алфавит",
                "Босс",
                "Гром",
                "Преступление и наказание",
                "Сказки",
                "Мастер и Маргарита",
                "Война и Мир",
                "Золушка",
                "Рыцарь",
                "Фараон",
                "Следопыт"));

        List<List<String>> test = arrangementOfBooks(books);
    }

    public static List<List<String>> arrangementOfBooks(List<String> booksCopy) {
        List<List<String>> shelves = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            List<String> shelf = new ArrayList<>();
            shelves.add(shelf);
        }
        booksCopy = booksCopy.stream()
                .sorted().
                toList();

        int count = 0;
        int booksOnShelf = booksCopy.size() / 5;
        int additionalBooks = booksCopy.size() % 5;

        for (List<String> shelf : shelves) {
            for (int i = 0; i < booksOnShelf; i++) {
                shelf.add(booksCopy.get(count++));
                if (additionalBooks-- > 0) {
                    shelf.add(booksCopy.get(count++));
                }
            }
        }
        shelves.stream().forEach(System.out::println);
        return shelves;
    }


}

