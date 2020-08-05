// Java program to remove duplicate elements from an array

package task4;

public class Q12_remove_duplicate_elements_array {
    public static void main(String[] args) {
        int arr[] = {1, 2, 4, 9, 7, 3, 4, 5, 8, 6, 1, 7, 8 };
        boolean dup [] = new boolean[arr.length];

        //Comparing each element with all other elements
        for (int i=0; i < arr.length; i++){
            for (int j=i+1; j < arr.length; j++){
                if (arr[i] == arr[j]) {
                    dup[i] = true; //marking true in case any duplicate value is found
                }
            }
        }

        for (int b=0; b < dup.length; b++){
            // printing only those values for which duplicate is false
            if (dup[b] == false)
            System.out.println(arr[b]);
        }
    }
}
