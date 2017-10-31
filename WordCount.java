package Assignments;

import jdk.nashorn.api.tree.Tree;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

public class WordCount {
    public static void main(String[] args) {
        TreeMap<String, Integer> wordMap = readAndCount("C:\\Users\\badkass\\Desktop\\Thread-Plural\\src\\path.txt");
        printMap(wordMap);
    }

    public static void printMap(TreeMap wordMap) {
        Set<String> keys = wordMap.keySet();
        for(String key: keys){
            System.out.println(key+ " = "+ wordMap.get(key));
        }
    }

    public static TreeMap<String, Integer> readAndCount(String filename) {
        TreeMap<String, Integer> wordMap = new TreeMap<>();
        BufferedReader br = null;
        FileReader fr = null;
        try {
            fr = new FileReader(filename);
            br = new BufferedReader(fr);
            String currentLine;
            while ((currentLine = br.readLine()) != null) {
                currentLine = currentLine.replaceAll("[\\W]", " ");
                String[] wordArray = currentLine.split(" ");
                for (String word : wordArray) {
                    int count = wordMap.containsKey(word.toLowerCase()) ? wordMap.get(word.toLowerCase()) : 0;
                    count = count + 1;
                    wordMap.put(word.toLowerCase(), count);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wordMap;
    }

}

