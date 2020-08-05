// to remove the duplicate elements of a given array and return the new length of the array.
package task4;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q19_remove_duplicate {
    public static void main(String[] args) {
        int arr [] = {11,7,4,5,10,11,7,10};

        // Convert int[] to Integer[]
        Integer[] newArray = new Integer[arr.length];
        int i = 0;
        for (int value : arr) {
            newArray[i] = Integer.valueOf(value);
            i++;
        }

        // Convert arr to Set
        Set<Integer> result = new HashSet<>(Arrays.asList(newArray));

        System.out.println("Original array length: "+arr.length);
        System.out.println("Array's new length: "+result.size());
    }
}
