package com.Miles.Lab_25_26;

public class Main {
    public static void main(String[] args) {
        MyHashMap<Integer, String> myHashMap = new MyHashMap<>();
        myHashMap.add(32, "2^5");
        myHashMap.add(64, "2^6");
        myHashMap.add(128, "2^7");
        myHashMap.add(256, "2^8");
        myHashMap.add(512, "2^9");
        myHashMap.add(1024, "1 kilobit");
        System.out.println("===Get All===");
        for (String value : myHashMap) {
            System.out.println(value);
        }
        System.out.println("===End of MyHashMap===");
        myHashMap.remove(128);
        System.out.println(myHashMap.get(128)); // Why not?
        System.out.println(myHashMap.get(32));
        System.out.println(myHashMap.get(64));
        myHashMap.remove(1000); // Let's try to do this
        System.out.println(myHashMap.get(1000)); // and this
        System.out.println(myHashMap.get(1024));
    }
}
