// Java program to find the second largest element in an array.

package task4;

public class Q13_second_largest_element_array {
    public static void main(String[] args) {
        int arr [] = {1,1,4,5,1,7,99,1199};
        int max1 = 0 , max2 = 0;
        for (int i=0; i < arr.length; i++){
            if (arr[i] > max1){
                max1 = arr[i];
            }
        }
        for (int i=0; i < arr.length; i++){
                if (arr[i] > max2 && arr[i] < max1)
                    max2 = arr[i];
        }
        System.out.println("2nd largest number: "+max2);
    }
}
