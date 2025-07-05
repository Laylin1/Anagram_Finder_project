package com.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.sun.tools.javac.Main;

public class AnagramFinder {

    //  Read/Write/Change file. (User's file)
    public static File wordsAFile = new File("data/words1m.txt");

    // Ready file for testts. Only Read.
    public static InputStream input = Main.class.getClassLoader().getResourceAsStream("example.txt");

    public static void main(String[] args) throws IOException {
        
        //Change readerType field on "file" for upload other file 
        String readerType = "file";

        //JVM access 
        Runtime runtime = Runtime.getRuntime();

        //gc for more clearly log memory usage
        runtime.gc();

        // Command Prompt argument, for start without changing code
        if (args.length > 0){
            readerType = args[0].toLowerCase();
        }

        BufferedReader reader = getRader(readerType);

        long before = runtime.totalMemory() - runtime.freeMemory();
        Map<String, List<String>> anagrams = findAnagrams(reader);
        long after = runtime.totalMemory() - runtime.freeMemory();

        logMemory("findAnagrams", after - before);
        
        for(List<String> word : anagrams.values()){
            System.out.println(String.join(" ", word));
        }


        // Counter anagrams
        // System.out.println(countAngrms(anagrams));

    }

    // Method for read file throught Buffer with saving in List
    /* 
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
    */


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

    //Method for grouping words with same keys(sorted)/Reading file without save words
    public static Map<String, List<String>> findAnagrams(BufferedReader reader) throws IOException{
        Map<String, List<String>> angraMap = new LinkedHashMap<>();
        String line;

        while ((line = reader.readLine()) != null){
            String[] words = line .trim().split("\\s+");

            for(String word : words){
                
                //Filetr for clean words
                if(word.matches("^[a-zA-Z]+$")){
                    String cleanWord = word.toLowerCase();
                    String key = sortString(cleanWord);

                    angraMap.computeIfAbsent(key, k -> new ArrayList<>()).add(cleanWord);
                    
                }
            }
        }

         return angraMap;
    }

    //Method for count anagrams for big files
    public static long countAngrms(Map<String, List<String>> anagrams){
        long count = anagrams.values().stream().filter(group -> group.size() > 1).count();
        return count;
    }

    //Method for log memory usage
    public static void logMemory(String label, long memoryUsedB) throws IOException{
        long usedMb = memoryUsedB /1024 /1024;
        String logLine = "{" + label +  "} Memory used: " + usedMb + "Mb\n";

        File logDir = new File("logs");

        if(!logDir.exists()){
            logDir.mkdirs();
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter("logs/memory.log", true));

        writer.write(logLine);

        writer.close();
    }
}