// sort HashMap in java by keys and values

package tasks.task7;

import java.util.*;

public class Q11_sort_HashMap {

    // map to store unsorted values
    static Map<String, Integer> map = new HashMap<>();

    public static void main(String args[])
    {
        // enter data into hashmap
        map.put("Tuli", 40);
        map.put("Ankur", 80);
        map.put("Abhinav", 90);
        map.put("Garima", 60);
        map.put("Ginni", 75);

        // Calling the function to sortbyKey
        sortByKeys();
        System.out.println();
        // Calling the function to sortbyValue
        sortByValues();
    }

    public static void sortByKeys()
    {
        // creating array list of keys from hashmap
        ArrayList<String> sortedKeys = new ArrayList<String>(map.keySet());

        // Sorting array list containing keys
        Collections.sort(sortedKeys);
        System.out.println("Hashmap sorted by keys: ");

        // Iterating through array list elements
        for (String x : sortedKeys) {
            // Printing keys and respective values from hashmap for those keys
            System.out.println(x + " : " + map.get(x));
        }
    }

    public static void  sortByValues(){
        // creating array list of values from hashmap
        ArrayList<Integer> sortedValues = new ArrayList<Integer>(map.values());

        // Sorting array list containing values
        Collections.sort(sortedValues);
        System.out.println("Hashmap sorted by values: ");

        // Iterating through array list elements
        for (Integer val : sortedValues) {
            // Iterating through hashmap
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                // if value exists in hashmap
                if (entry.getValue().equals(val)) {
                    // print respective key & value from hashmap
                    System.out.println(entry.getKey() + " : " + val);
                }
            }
        }
    }
}

