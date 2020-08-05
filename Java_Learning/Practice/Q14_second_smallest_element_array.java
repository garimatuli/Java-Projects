// Java program to find the second smallest element in an array.

package task4;

public class Q14_second_smallest_element_array {
    public static void main(String[] args) {
        int arr [] = {1,1,4,5,1,7,99,1199};
        int min1 = Integer.MAX_VALUE , min2 = Integer.MAX_VALUE;
        for (int i=0; i < arr.length; i++){
            if (arr[i] < min1){
                min1 = arr[i];
            }
        }
        for (int i=0; i < arr.length; i++){
                if (arr[i] < min2 && arr[i]> min1)
                    min2 = arr[i];
        }
        System.out.println("2nd smallest number: "+min2);
    }
}
