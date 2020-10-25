package com.Miles.Lab_13;

import java.util.Scanner;

public class Test {
    public static void main(String[] args){

        Research res = new Research();
        try {
            res.addTimeForResearch(Integer.parseInt(new Scanner(System.in).nextLine()));
            res.addTimeForResearch(100);
            res.addTimeForResearch(-200);
        }
        catch (TryIncorrectFormat tif){
            System.out.println("Value must be >=0");
        }
        catch (NumberFormatException nfe)
        {
            System.out.println("Incorrect input format");
        }
        finally {
            System.out.println("=== We have some research! ===");
            System.out.println(res);
        }

        System.out.println("\u001B[32m" + "Look out! We should not use the try catch block for the exception below." + "\u001B[30m");
        throw new ExtraRuntimeException();
    }

}
