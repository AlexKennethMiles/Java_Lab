package com.Miles.Lab_21_22;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        ItemStore storageType = null;
        int id = 0;
        String data;
        boolean isGood;
        String description;
        System.out.println("What kind of realization will be used(file or server)?");
        String input = (sc.nextLine()).toLowerCase();
        if (input.equals("file")) {
            storageType = new LocalJson();
        } else if (input.equals("server")) {
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
            switch (sc.nextLine().toLowerCase()) {
                case "1":
                    List<Item> items = storageType.getAll();
                    for (Item i : items) {
                        System.out.println(i);
                    }
                    break;
                case "2":
                    System.out.println("Enter the ID of the item:");
                    id = sc.nextInt();
                    if (storageType.get(id) == null) {
                        System.out.println("There is no aitem with this ID");
                    } else {
                        System.out.println(storageType.get(id) + " " + "Description: " + storageType.get(id).getDescription());
                    }
                    break;
                case "3":
                    System.out.println("Creating a new item:");
                    System.out.print("ID:");
                    id = sc.nextInt();
                    System.out.print("Data:");
                    data = sc.nextLine();
                    System.out.print("isGood:");
                    isGood = sc.nextBoolean();
                    System.out.print("description:");
                    description = sc.nextLine();
                    storageType.addItem(new Item(id, data, isGood, description));
                    break;
                case "4":
                    System.out.println("Creating a buffer item to change an existing one");
                    System.out.print("ID:");
                    id = sc.nextInt();
                    System.out.print("Data:");
                    data = sc.next();
                    System.out.print("isGood:");
                    isGood = sc.nextBoolean();
                    System.out.print("description:");
                    description = sc.next();
                    Item item = new Item(id, data, isGood, description);
                    System.out.println("ID of the item to change:");
                    id = sc.nextInt();
                    storageType.editItem(item, id);
                    break;
                case "5":
                    System.out.println("ID of the item to delete:");
                    storageType.deleteItem(sc.nextInt());
                    break;
                case "6":
                    return;
            }
        }
    }

}