package org.example;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
//maven dependency
import java.io.*;
import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;

class Person{
    private String name;
    private int age;
    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }
}
public class Task2 {
    static ArrayList<Person> people = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        readFile();
        writeGson();
    }

    /*цей метод читає файл, перетворює кожен рядок (крім першого) у обєкт
    та додає ці обєкти в список
     */
    public static void readFile() throws IOException {
        String[] temp;
        BufferedReader reader = new BufferedReader(new FileReader("file.txt"));
        String line = reader.readLine();
        while((line = reader.readLine()) != null){

            temp = line.split(" ");
            Person person = new Person(temp[0], Integer.valueOf(temp[1]));
            people.add(person);
        }

        reader.close();

    }

    //цей метод створює файл .json та записуэ туди список у відповідному форматі
    public static void writeGson() throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter writer = new FileWriter("user.json");
        gson.toJson(people, writer);
        writer.close();
    }
}
