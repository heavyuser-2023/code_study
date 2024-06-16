package com.heavyuser.josephus;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        FileReader fr = new FileReader("input.txt");
        String input = "";
        try (BufferedReader br = new BufferedReader(fr)) {
            String line;
            while( (line = br.readLine()) != null) {
                input = line;
            }
        }
        
        
        input.strip();
        String splitedInput [] = input.split(" ");
        
        int a = Integer.valueOf(splitedInput[0].strip());
        int step = Integer.valueOf(splitedInput[1].strip());

        List<Integer> il = new ArrayList<>();
        for(int i=1;i<=a;i++) {
            il.add(i);
        }

        List<Integer> ol = new ArrayList<>();

        int index = 0;
        while(il.size() > 0) {
            index = (index + step-1) % il.size();
            ol.add(il.get(index));
            il.remove(index);
        }

        FileWriter fw = new FileWriter("output.txt");
        try(BufferedWriter bw = new BufferedWriter(fw)) {
            String out = "<" + String.join(",", ol.stream().map(Object::toString).toList()) + ">";
            System.out.println(out);
            bw.write(out);

        }  
    }
}
