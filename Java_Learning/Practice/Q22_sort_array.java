/* to sort an array of positive integers of a given array,
 * in the sorted array the value of the first element should be maximum, second value should be minimum value, third should be second maximum, fourth second be second minimum and so on. */
package task4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q22_sort_array {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7}; //sorted array
        int result[] = new int [arr.length]; //array to hold result

        //Store indexes of largest & smallest elements
        int maxIndex = arr.length-1, minIndex = 0 ;

        for (int i = 0; i < arr.length; i++) {
            // filling elements at 0 or even index
            if (i % 2 == 0) {
                result[i] =  arr[maxIndex];
                maxIndex--;
            }
            else { // filling elements at odd index
                result[i] = arr[minIndex];
                minIndex++;
            }
        }

        // Iterating over result array
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}

