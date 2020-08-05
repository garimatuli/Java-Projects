/* a program to remove the duplicates from a sorted array change them into 0 and add 0 in the end.
    a.	input: [2,2,3,3,4,4,4,11,11,11,11]
    b.	output:[2,3,4,11,0,0,0,0,0,0,0]
   */

package task4;

public class Q17_sorted_array_remove_duplicates_add_0_at_end {
    public static void main(String[] args) {
        int arr [] = {2,2,3,3,4,4,4,11,11,11,11};
        int result[] = new int [arr.length]; // to store result
        int count = 0 ; // counter for duplicate elements or the zeros to be added at the end
        int j = 0 ; // index for result array

        // looping over array
        for (int i=0; i < arr.length; i++){
            if (i < arr.length-1 && arr[i] == arr[i+1]){
                count++;
            }else {
                result[j] = arr[i];
                j++;
            }
        }

        // fill rest elements of result with 0 depending on the zero counter (count)
        while(count!=0){
            result[j] = 0;
            j++;
            count--;
        }

        // printing result
        for (int k=0; k < result.length; k++) {
            System.out.print(result[k] + " ");
        }
    }
}
