/* program to find the sum of the two elements of a given array which is equal to a given integer. */

package task4;

import java.util.*;

public class Q20_sum_of_elements_matching_target {
    public static void main(String[] args) {
        int arr[] = {1,2,4,5,6};
        Integer newArray [] = new Integer[arr.length];
        int target = 6;
        int sum = Integer.MIN_VALUE;

        //Convert int[] to Integer[]
        int i = 0;
        for (int val : arr){
            newArray[i] = val;
            i++;
        }

        // Convert Integer[] into an ArrayList
        List<Integer> al = new ArrayList<>(Arrays.asList(newArray));

        // Map to store key value pairs for Array List's values & indices
        Map<Integer,Integer> myMap = new HashMap<>();

        // Iterating over the Map
        for (int j = 0; j < al.size(); j++){
            Integer y = target - al.get(j);
            if (myMap.containsKey(y)){
                sum = y + al.get(j);
                System.out.println("Sum of elements "+y+" and "+al.get(j)+" equals the given target "+target);
                break;
            }else {
                myMap.put(al.get(j),j); // putting key as ArrayList's value & value as ArrayList's index in map
            }
        }
        if (sum == Integer.MIN_VALUE) {
            System.out.println("No such sum exists");
        }
    }
}
