/*program that accepts three numbers from the user and prints "INCREASING" if the numbers are in increasing order, "DECREASING" if the numbers are in decreasing order, and "Neither increasing or decreasing order" otherwise.
FOR eg.
●	Input first number: 1524
●	Input second number: 2345
●	Input third number: 3321
Output : INCREASING
*/
package task3_looping_statements;

import java.util.Scanner;

public class Q6_inc_decreasing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input first number: ");
        int num1 = sc.nextInt();
        System.out.println("Input second number: ");
        int num2 = sc.nextInt();
        System.out.println("Input third number: ");
        int num3 = sc.nextInt();
        if (num1< num2 && num2 < num3){
            System.out.println("Increasing");
        }
        else if (num1> num2 && num2 > num3){
            System.out.println("Decreasing");
        }
        else {
            System.out.println("Neither increasing or decreasing order");
        }
    }
}
