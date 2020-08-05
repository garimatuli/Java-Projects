// Java program to move all 0's to the end of an array.
// Maintain the relative order of the other (non-zero) array elements.

package task4;

public class Q16_move_zeros_to_end {
    public static void main(String[] args) {
        int arr [] = {0,1,2,0,6,5,0,0,9,75}; //initial array
        int result[] = new int[arr.length]; // to store result
        // count is a counter for number of zero's & j is an index for result array
        int j = 0 , count = 0;

        // iterating over array
        for (int i=0; i < arr.length; i++){
            if (arr[i] != 0){
                result[j] = arr[i]; // element put into result if its not a 0
                j++;
            }else{
                count++; // count increases if number is 0
            }
        }
        // fill rest elements of result with 0 depending on the zero counter (count)
        while(count!=0){
            result[j] = 0;
            j++;
            count--;
        }
        // printing result
        for (int k=0; k<result.length; k++) {
            System.out.print(result[k] + " ");
        }
    }
}
