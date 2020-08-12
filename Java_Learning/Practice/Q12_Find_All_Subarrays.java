// Program to find all the sub-arrays whose sum is equal to the given number

package tasks.task7;

    import java.util.*;

public class Q12_Find_All_Subarrays {
    public static void main(String args[]) {

        //Reading the array from the user
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter array size: "); // 8
        int size = sc.nextInt();

        int[] myArray = new int[size];

        System.out.println("Enter array elements: ");
        for (int i = 0; i < size; i++) {
            myArray[i] = sc.nextInt();
        }

        //Reading the number
        System.out.println("Enter the required sum: ");
        int reqSum = sc.nextInt();

        System.out.println("The array created is: " + Arrays.toString(myArray)); // [1, 2, 3, 6, 5, 1, 4, 2]

        System.out.println("Sub arrays whose sum is: " + reqSum); // 6
        printallSubarrays(myArray, reqSum);
    }

    static void printallSubarrays(int[] myArray, int reqSum) {
        for (int i = 0; i < myArray.length; i++) {
            int sum = 0;
            for (int j = i; j < myArray.length; j++) {
                sum = sum + myArray[j];
                if (sum == reqSum) {
                    System.out.println(Arrays.toString(Arrays.copyOfRange(myArray, i, j + 1)));
                }
            }
        }
    }
}
