/*takes one integer input n from the user,
and print sum of n natural numbers.*/
package task3_looping_statements;

import java.util.Scanner;

public class Q4_natural_numbers_sum {
    public static void main(String[] args) {
        int sum = 0;
        Scanner sc  = new Scanner(System.in);
        System.out.println("Enter a number:");
        int num = sc.nextInt();
        for (int i = 1; i <= num; i++) {
            sum = sum + i;
        }
        System.out.println("Sum: " + sum);
    }
}
