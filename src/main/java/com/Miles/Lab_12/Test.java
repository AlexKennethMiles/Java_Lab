package com.Miles.Lab_12;

public class Test {
    public static void main(String[] args) {
        returnWithColor("WHITE",SomeEnum.WHITE);
        returnWithColor("RED",SomeEnum.RED);
        returnWithColor("GREEN",SomeEnum.GREEN);
        returnWithColor("YELLOW",SomeEnum.YELLOW);
        returnWithColor("BLUE",SomeEnum.BLUE);
        returnWithColor("PURPLE",SomeEnum.PURPLE);
        returnWithColor("CYAN",SomeEnum.CYAN);
        returnWithColor("This is not WHITE, but GREY",SomeEnum.GREY);

    }

    public static void returnWithColor(String s, SomeEnum color){
        for (int i = 0; i < 4; i++) {
            System.out.print(color.getColor() + s);
            if (i != 3){
                System.out.print(" | ");
            }
        }
        System.out.println();
    }
}


