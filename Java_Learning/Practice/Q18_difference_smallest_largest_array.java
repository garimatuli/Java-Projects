/* Java program to get the difference between the largest and smallest values in an array of integers.
The length of the array must be 1 and above.
*/

package task4;

public class Q18_difference_smallest_largest_array {
    public static void main(String[] args) {
        int arr [] = {11,11,4,5,10,7,99,100};
        int max = Integer.MIN_VALUE , min = Integer.MAX_VALUE;

        for (int i=0; i < arr.length; i++){
            if (arr[i] > max){
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        System.out.printf("Difference of largest & smallest number = "+max+" - "+min+ " = " +Math.abs(max-min));
    }
}
