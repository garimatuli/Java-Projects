// method to remove all the spaces from the String and return the resultant.
package tasks.task5_arrays_and_strings;

import java.util.Scanner;

public class Q3_remove_spaces {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a String: ");
        String myStr = sc.nextLine();
        // replacing spaces & storing result in new string as a string is immutable
        String str = myStr.replaceAll(" ","");
        System.out.println(str);
    }
}
