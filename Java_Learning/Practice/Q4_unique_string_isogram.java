/* method to return a boolean true if the string doesn’t have repeating letters and
consecutive or nonconsecutive i.e. all the letters of the string be unique (isogram) else false. */

package tasks.task5_arrays_and_strings;

import java.util.Arrays;
import java.util.Scanner;

public class Q4_unique_string_isogram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a String: ");
        String myStr = sc.nextLine();

        System.out.println(checkIsogram(myStr));
    }

    static boolean checkIsogram(String myStr){
        // converting string to lower case & removing spaces in case of a multi-word string
        String str = myStr.toLowerCase().replaceAll(" ","");

        // Changing string to character array
        char arr[] = str.toCharArray();

        // sorting character array
        Arrays.sort(arr);

        //looping over sorted character array
        for(int i = 0 ; i < arr.length-1 ; i++){
            if (arr[i] == arr[i+1]) {
                return false;
            }
        }
        return true;
    }
}
