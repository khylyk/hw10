package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Task3 {
    static HashMap<String, Integer> occurences = new HashMap<>();
    static Set<String> words = new HashSet<>();
    static ArrayList allWords = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        wordsToList();
        countOccurences();
        System.out.println(occurences);
    }
    /*читаємо файл, конвертуємо його у:
    1. хеш сет унікальних слів
    2. список усіх слів
     */

    public static void wordsToList() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("words.txt"));
        String line = reader.readLine();
        while(line != null){
            String[] split = line.split(" ");
            for(int i = 0; i < split.length; i++){
                words.add(split[i]);
                allWords.add(split[i]);
            }
            line = reader.readLine();
        }

    }

    //рахуємо скільки разів зустрічається кожне слово та додаємо у хеш меп
    public static void countOccurences(){
        for(String key : words){
            occurences.put(key, Collections.frequency(allWords, key));
        }
    }
}
