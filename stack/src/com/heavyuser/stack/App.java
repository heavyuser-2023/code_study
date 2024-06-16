package com.heavyuser.stack;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Stack test start");

        Stack stack = new Stack();

        String currentPath = System.getProperty("user.dir");
        System.out.println(String.format("current path : %s", currentPath));
        File file = new File("input.txt");
        FileWriter outFileWriter = new FileWriter("output.txt");
        BufferedWriter writer;
        writer = new BufferedWriter(outFileWriter);

        Scanner scanner = new Scanner(file);

        int inputSize = 0;
        if(scanner.hasNextLine())
        {
            inputSize = Integer.valueOf(scanner.nextLine());
        }

        try {
            for(int i=0;i<inputSize;i++) {
                String line = scanner.nextLine();
                String [] command = line.split(" ");
                switch (command[0]) {
                    case "push" -> {
                        stack.push(Integer.valueOf(command[1]));
                    }
                    case "pop" -> {
                        writer.write(String.valueOf(stack.pop()));
                        writer.newLine();
                    }

                    case "top" -> {
                        writer.write(String.valueOf(stack.top()));
                        writer.newLine();
                    }
                    
                    case "empty" -> {
                        writer.write(String.valueOf(stack.empty()));
                        writer.newLine();
                    }

                    case "size" -> {
                        writer.write(String.valueOf(stack.size()));
                        writer.newLine();
                    }
                    default -> {

                    }
                } // Add closing brace here
            }   
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(writer != null) {
                writer.close();
            }
        }

        scanner.close();


        

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(String.format("top : %d" , stack.top()));
        System.out.println(String.format("empty : %d" , stack.empty()));
        System.out.println(String.format("size : %d" , stack.size()));
        System.out.println();

        System.out.println(String.format("pop : %d" , stack.pop()));
        System.out.println(String.format("empty : %d" , stack.empty()));
        System.out.println(String.format("size : %d" , stack.size()));
        System.out.println();
        
        System.out.println(String.format("pop : %d" , stack.pop()));
        System.out.println(String.format("empty : %d" , stack.empty()));
        System.out.println(String.format("size : %d" , stack.size()));
        System.out.println();
        
        System.out.println(String.format("pop : %d" , stack.pop()));
        System.out.println(String.format("empty : %d" , stack.empty()));
        System.out.println(String.format("size : %d" , stack.size()));
        System.out.println();
        
        System.out.println(String.format("top : %d" , stack.pop()));
        System.out.println(String.format("empty : %d" , stack.empty()));
        System.out.println(String.format("size : %d" , stack.size()));
        System.out.println();
        
        System.out.println(String.format("top : %d" , stack.pop()));
        System.out.println(String.format("empty : %d" , stack.empty()));
        System.out.println(String.format("size : %d" , stack.size()));
        System.out.println();

    }
}
