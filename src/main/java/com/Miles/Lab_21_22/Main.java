package com.Miles.Lab_21_22;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc=new Scanner(System.in);
        ItemStore storageType=null;
        int id=0;
        String data;
        boolean isGood;
        String description;
        System.out.println("What kind of realization will be used(file or server)?");
        String input=(sc.nextLine()).toLowerCase();
        if (input.equals("file")){
            storageType=new FileJson();}
        else if(input.equals("server")) {
            storageType = new Server();
        }
        System.out.println("Choose one of the command. To complete program execution please type 'exit' ");
        while(true){
            switch (sc.nextLine().toLowerCase()){
                case("get all"):
                    List<Item> items=storageType.getAll();
                    for(Item i: items){
                        System.out.println(i);
                    }
                    break;
                case("get"):
                    System.out.println("Choose item's id");
                    id=sc.nextInt();
                    if(storageType.get(id)==null) {System.out.println("There is no item with the id.");}
                    else{
                        System.out.println(storageType.get(id)+" "+"Description: "+storageType.get(id).getDescription());
                    }
                    break;
                case("add item"):
                    System.out.println("Please create new item. To do it you need to fill in following fields.");
                    System.out.print("Id:"); id=sc.nextInt();
                    System.out.print("Data:"); data=sc.nextLine();
                    System.out.print("isGood:"); isGood=sc.nextBoolean();
                    System.out.print("description:"); description=sc.nextLine();
                    storageType.addItem(new Item(id,data,isGood,description));
                    break;
                case("edit item"):
                    System.out.println("Please create new item that tou want to insert. To do it you need to fill in following fields.");
                    System.out.print("Id:"); id=sc.nextInt();
                    System.out.print("Data:"); data=sc.next();
                    System.out.print("isGood:"); isGood=sc.nextBoolean();
                    System.out.print("description:"); description=sc.next();
                    System.out.println("Id of item instead of which you want to insert new item");
                    Item item=new Item(id,data,isGood,description);
                    id=sc.nextInt();
                    storageType.editItem(item,id);
                    break;
                case("delete item"):
                    System.out.println("Provide an id of the item that you want to delete");
                    storageType.deleteItem(sc.nextInt());
                    break;
                case("exit"):
                    return;
            }
        }
    }

}