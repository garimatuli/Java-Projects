/*program that takes long type input from user, and
d.	Calculate and display the number of digits.
e.	Calculate the sum of all the digits of the input.
*/
package task3_looping_statements;

import java.util.Arrays;
import java.util.Scanner;

public class Q5_long_input {
    public static void main(String[] args) {
        int sum = 0;
        Scanner sc  = new Scanner(System.in);
        System.out.println("Enter a number:");
        long num = sc.nextLong();
        
        //converting long num to string
        String n = Long.toString(num);

        // calculating length of string
        int len = n.length();

        // iterating through string & adding digits
        for (int i = 0; i < len; i++) {
            // Extracting single char from string using str.charAt(index)
            // char to String using String.valueOf(char)
            // String to int using Integer.parseInt(str)
            sum = sum + Integer.parseInt(String.valueOf(n.charAt(i))) ;
        }
        System.out.println("Length: " + len);
        System.out.println("Sum: " + sum);
    }
}
