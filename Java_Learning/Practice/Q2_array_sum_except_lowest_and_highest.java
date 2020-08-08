// program that gives sum of all the values of array except the highest and lowest values.
package tasks.task5_arrays_and_strings;

public class Q2_array_sum_except_lowest_and_highest {
    public static void main(String[] args) {
        int arr [] = {2,66,3,4,1,9};
        int sum = 0, max = arr[0], min = arr[0];
        for (int i : arr){

            // sum of all numbers
            sum = sum + i;

            //Finding max number
            if( i > max){
                max = i;
            }

            //Finding min number
            if( i < min){
                min = i;
            }
        }
        // Result = sum of al numbers - sum of min & max number
        System.out.println("Result = " + (sum-(min+max))); //18
    }
}
