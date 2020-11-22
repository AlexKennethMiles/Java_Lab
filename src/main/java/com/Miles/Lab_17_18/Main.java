package com.Miles.Lab_17_18;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            printer = new PrintWriter("Lab_17_18.md"); // creating a file to record the result of the program
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        getPathAndCode("G:\\IntelliJ IDEA\\MainFolder\\Java_Lab\\src");
        printer.close();
    }

    static PrintWriter printer;

    public static void getPathAndCode(String path) {
        File file = new File(path); // "everything is a file" (reference to Linux)

        if (file.isDirectory()) { // if we came across a folder
            String[] data = file.list();
            for (String s : data) { // view all files in this folder
                getPathAndCode(path + "\\" + s); // recursively call the same method for each found file
            }
        }
        if (file.isFile()) { // if we came across a file
            if (file.getName().substring(file.getName().lastIndexOf(".")).equals(".java")) { // we consider files with the .java extension
                try (BufferedReader reader = new BufferedReader(new FileReader(path))) { // reading the contents of the file
                    printer.write("### " + path + "\n```java\n"); // beginning of the file code
                    String line = reader.readLine();
                    while (line != null) { // read each line separately until they run out
                        printer.write(line + "\n"); // write a line to the printer (result)
                        line = reader.readLine();
                    }
                    printer.write("```\n"); // end of the code block
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}