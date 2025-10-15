package org.example.models;

import java.util.*;

public class Grocery {

    public static final ArrayList<String> groceryList = new ArrayList<>();

    public static void startGrocery() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== GROCERY LIST ===");
        System.out.println("Komutlar: 0 -> Çıkış | 1 -> Ekle | 2 -> Çıkar");
        printSorted();

        boolean running = true;
        while (running) {
            System.out.print("\nSeçiminiz (0/1/2): ");
            String token = scanner.nextLine().trim();

            switch (token) {
                case "0":
                    running = false;
                    System.out.println("Uygulama sonlandırıldı. Görüşürüz!");
                    break;
                case "1":
                    System.out.println("Eklemek istediğiniz eleman(lar)ı girin.");
                    System.out.println("Örn: tomato veya tomato, orange, peach");
                    String toAdd = scanner.nextLine();
                    addItems(toAdd);
                    printSorted();
                    break;
                case "2":
                    System.out.println("Çıkarmak istediğiniz eleman(lar)ı girin.");
                    System.out.println("Örn: tomato veya tomato, orange, peach");
                    String toRemove = scanner.nextLine();
                    removeItems(toRemove);
                    printSorted();
                    break;
                default:
                    System.out.println("Geçersiz seçim. Lütfen 0 / 1 / 2 giriniz.");
            }
        }
    }

    public static void addItems(String input) {
        if (input == null || input.isBlank()) return;
        String[] parts = input.split(",");
        for (String raw : parts) {
            String item = normalize(raw);
            if (item.isEmpty()) continue;
            if (!checkItemIsInList(item)) {
                groceryList.add(item);
            }
        }
        Collections.sort(groceryList);
    }


    public static void removeItems(String input) {
        if (input == null || input.isBlank()) return;
        String[] parts = input.split(",");
        for (String raw : parts) {
            String item = normalize(raw);
            if (item.isEmpty()) continue;
            groceryList.remove(item);
        }
        Collections.sort(groceryList);
    }


    public static boolean checkItemIsInList(String product) {
        if (product == null) return false;
        String p = normalize(product);
        return groceryList.contains(p);
    }

    public static void printSorted() {
        Collections.sort(groceryList);
        System.out.println("\nGüncel Liste (alfabetik): " + groceryList);
    }

    private static String normalize(String s) {
        return s == null ? "" : s.trim().toLowerCase(Locale.ROOT);
    }
}
