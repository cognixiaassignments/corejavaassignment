package com.cognixia.jump.corejava.corejavaassignment;

import java.util.Map;
import java.util.TreeMap;

public class UniqueWordCounter {
	 public static void main(String[] args) {
		String str = "Hello HELLO worlD WORld hi";
		countWords(str);
	 }
	
	 public static void countWords(String str) {
		 Map<String, Integer> map = new TreeMap<>();
		 
		 // adds keys and values to the map
		 for(String word : str.toLowerCase().split("\\W")) {
		    if(map.containsKey(word)) {
		        map.put(word, map.get(word)+1);
		    }
		    else {
		        map.put(word, 1);
		    }
		}

		// prints out each unique word and the number of times it appears 
		for(Map.Entry<String, Integer> entry : map.entrySet()) {
		    System.out.println(entry.getKey() + ": " + entry.getValue());
		}
	 }
} 

