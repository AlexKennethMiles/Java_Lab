package com.Miles.Lab_21_22;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner cin = new Scanner(System.in);
        ItemStore storageType = null;
        int id = 0;
        String data;
        boolean isGood;
        String description;

        System.out.println("Choose one of the realization");
        System.out.println("1 -- Server");
        System.out.println("2 -- Local file");
        String input = (cin.nextLine()).toLowerCase();
        if (input.equals("1")) {
            storageType = new LocalJson();
        } else if (input.equals("2")) {
            storageType = new Server();
        }
        System.out.println("Choose one of the command");
        System.out.println("1 -- Get all");
        System.out.println("2 -- Get");
        System.out.println("3 -- Add item");
        System.out.println("4 -- Edit item");
        System.out.println("5 -- Delete item");
        System.out.println("6 -- Exit");

        while (true) {
            switch (cin.nextLine().toLowerCase()) {
                case "1":
                    List<Item> items = storageType.getAll();
                    for (Item i : items) {
                        System.out.println(i);
                    }
                    break;
                case "2":
                    System.out.println("Enter the ID of the item:");
                    id = cin.nextInt();
                    if (storageType.get(id) == null) {
                        System.out.println("There is no aitem with this ID");
                    } else {
                        System.out.println(storageType.get(id) + " " + "Description: " + storageType.get(id).getDescription());
                    }
                    break;
                case "3":
                    System.out.println("Creating a new item:");
                    System.out.print("ID:");
                    id = cin.nextInt();
                    System.out.print("Data:");
                    data = cin.nextLine();
                    System.out.print("isGood:");
                    isGood = cin.nextBoolean();
                    System.out.print("description:");
                    description = cin.nextLine();
                    storageType.addItem(new Item(id, data, isGood, description));
                    break;
                case "4":
                    System.out.println("Creating a buffer item to change an existing one");
                    System.out.print("ID:");
                    id = cin.nextInt();
                    System.out.print("Data:");
                    data = cin.next();
                    System.out.print("isGood:");
                    isGood = cin.nextBoolean();
                    System.out.print("description:");
                    description = cin.next();
                    Item item = new Item(id, data, isGood, description);
                    System.out.println("ID of the item to change:");
                    id = cin.nextInt();
                    storageType.editItem(item, id);
                    break;
                case "5":
                    System.out.println("ID of the item to delete:");
                    storageType.deleteItem(cin.nextInt());
                    break;
                case "6":
                    return;
            }
        }
    }

}