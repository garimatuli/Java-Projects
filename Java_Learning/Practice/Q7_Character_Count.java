// Program to Count occurrences of each character in a string in java
package tasks.task7;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Q7_Character_Count {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // String input from user
        System.out.println("Enter any string: ");
        String str = sc.nextLine();

        // Remove any space from string
        String myStr = str.toLowerCase().replaceAll(" ","");
        System.out.println(myStr);
        // Creating Hashmap to store characters & count of each character
        HashMap<Character,Integer> myMap = new HashMap<>();

        for (int i = 0; i < myStr.length() ; i++) {
            if (myMap.containsKey(myStr.charAt(i))){
               myMap.put(myStr.charAt(i),myMap.get(myStr.charAt(i)) + 1);
            }
            else{
                myMap.put(myStr.charAt(i),1);
            }
        }

        // Using for-each to iterate through a HashMap
//        for (Map.Entry<Character, Integer> entry : myMap.entrySet()) {
//            System.out.println(entry.getKey() + " occurs " + entry.getValue()+ " times");
//        }

//        OR

        // Iterating through HashMap with Lambda Expressions (Java 8)
        myMap.forEach((key,value) -> System.out.println(key + " occurs " + value+ " times"));
    }
}
