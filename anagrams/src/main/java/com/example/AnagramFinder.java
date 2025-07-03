package com.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.sun.tools.javac.Main;

public class AnagramFinder {

    //  Read/Write/Change file. (User's file)
    public static File wordsAFile = new File("data/exampleUser.txt");

    // Ready file for testts. Only Read.
    public static InputStream input = Main.class.getClassLoader().getResourceAsStream("example.txt");

    public static void main(String[] args) throws IOException {
        
        //Change readerType field on "file" for upload other file 
        String readerType = "resource";

        // Command Prompt argument, for start without changing code
        if (args.length > 0){
            readerType = args[0].toLowerCase();
        }

        BufferedReader reader = getRader(readerType);


        List<String> words = readWords(reader);

        Map<String, List<String>> anagrams = findAnagrams(words);
        
        for(List<String> word : anagrams.values()){
            System.out.println(String.join(" ", word));
        }

    }

    // Method for read file throught Buffer
    public static List<String> readWords(BufferedReader reader) throws IOException{
        List<String> wordList = new ArrayList<>();

            String line;

            while((line = reader.readLine()) != null) {
                String[] words = line.trim().split("\\s+");
                Collections.addAll(wordList, words); 
            }
            reader.close();


        return wordList;
    }

    // Method for swap between user's file or ready file
    public static BufferedReader getRader(String source) throws IOException {
        BufferedReader reader;

        if(source.equalsIgnoreCase("file")) {
            reader = new BufferedReader(new FileReader(wordsAFile));
        } else if(source.equalsIgnoreCase("resource")) {
            reader = new BufferedReader(new InputStreamReader(input));
        } else {
            throw new IllegalArgumentException(source);
        }

        return reader;
    }

    // MEthod for sorting chars
    public static String sortString(String word){
        char[] chars = word.toLowerCase().toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    //Method for grouping words with same keys(sorted letters)
    public static Map<String, List<String>> findAnagrams(List<String> words){
        Map<String, List<String>> angraMap = new LinkedHashMap<>();

        for(String word : words){
            String key = sortString(word);

            angraMap.computeIfAbsent(key, k -> new ArrayList<>()).add(word);

        }

         return angraMap;
    }
}