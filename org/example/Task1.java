package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task1 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("file.txt"));
        String line;

        Pattern pattern1 = Pattern.compile("\\(\\d{3}\\) \\d{3}-\\d{4}"); //патерн на перший регулярний вираз - 3 цифри в дужках, тире, 4 цифри
        Pattern pattern2 = Pattern.compile("\\d{3}-\\d{3}-\\d{4}");//другий паттерн - ххх-ххх-хххх
        Matcher matcher1;
        Matcher matcher2;

        while((line = reader.readLine()) != null){
            matcher1 = pattern1.matcher(line);
            matcher2 = pattern2.matcher(line);
            //перевіряємо чи номер у одному з форматів
            if(matcher1.matches() || matcher2.matches()){
                System.out.println(line);
            }
        }
        reader.close();
    }
}
