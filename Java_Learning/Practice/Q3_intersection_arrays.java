//Program to find the intersection of two arrays
package tasks.task7;

import java.util.HashSet;

public class Q3_intersection_arrays {
    public static void main(String[] args) {
        int arr1 [] = {7, 1, 5, 2, 3, 6};
        int arr2[] = {3, 8, 6, 20, 7};

        // Iterate through 1st array & put every element of it in the set
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < arr1.length ; i++){
            hs.add(arr1[i]);
        }

        System.out.println("Intersection of two arrays is :");
        // For every element x of the 2nd array,Search x in the set hs.
        // If x is present, then print it.
        for (int i = 0; i < arr2.length ; i++){
            if (hs.contains(arr2[i])) {
                System.out.print(arr2[i] + " ");
            }
        }
    }
}
