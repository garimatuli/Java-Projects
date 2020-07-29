/*a. Take 10 values input from user using loop.
b.	Print sum of all the numbers provided
c.	Print the Average of those 10 values
*/
package task3_looping_statements;

import java.util.Scanner;

public class Q2_sum_average {
    public static void main(String[] args) {
        int sum = 0, num = 0;
        double avg = 0.0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter 10 values:");
        for (int i = 0; i < 10; i++) {
            num = sc.nextInt();
            sum = sum + num;
        }
        avg = sum / 10.0;
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + avg);
    }
}
