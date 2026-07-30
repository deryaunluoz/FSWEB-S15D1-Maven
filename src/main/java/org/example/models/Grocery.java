package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Grocery {

    public static ArrayList<String> groceryList = new ArrayList<>();

    public static void startGrocery() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("0: Cikis yap");
            System.out.println("1: Eleman ekle");
            System.out.println("2: Eleman cikar");
            System.out.print("Seciminiz: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "0":
                    running = false;
                    System.out.println("Uygulama sonlandirildi.");
                    break;
                case "1":
                    System.out.print("Eklemek istediginiz elemanlari giriniz (virgulle ayirabilirsiniz): ");
                    String addInput = scanner.nextLine();
                    addItems(addInput);
                    break;
                case "2":
                    System.out.print("Cikarmak istediginiz elemanlari giriniz (virgulle ayirabilirsiniz): ");
                    String removeInput = scanner.nextLine();
                    removeItems(removeInput);
                    break;
                default:
                    System.out.println("Gecersiz secim, tekrar deneyiniz.");
            }
        }
    }

    public static void addItems(String input) {
        String[] items = input.split(",");
        for (String item : items) {
            String trimmedItem = item.trim();
            if (!trimmedItem.isEmpty() && !checkItemIsInList(trimmedItem)) {
                groceryList.add(trimmedItem);
            }
        }
        printSorted();
    }

    public static void removeItems(String input) {
        String[] items = input.split(",");
        for (String item : items) {
            String trimmedItem = item.trim();
            if (checkItemIsInList(trimmedItem)) {
                groceryList.remove(trimmedItem);
            }
        }
        printSorted();
    }

    public static boolean checkItemIsInList(String product) {
        return groceryList.contains(product);
    }

    public static void printSorted() {
        Collections.sort(groceryList);
        System.out.println(groceryList);
    }
}