// Write a program in JAVA to perform the following operation:
// If a number is divisible by 3 it should print “Consultadd” as a string
// If a number is divisible by 5 it should print “JAVA Training” as a string
// If a number is divisible by both 3 and 5 its should print “Consultadd JAVA Training” as a string.

package task2;

import java.util.Scanner;

public class Divisible {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a positive number: ");
        int num = sc.nextInt();
        if (num%3==0){
            if (num%5==0) {
                System.out.println("Consultadd JAVA Training"); // Divisible by both 3 & 5
            }
            else {
                System.out.println("Consultadd"); // Divisible by 3
            }
        }else if (num%5==0) {
            System.out.println("JAVA Training"); // Divisible by 5
        }
        else {
            System.out.println("Not divisible by 3 or 5");
        }
    }
}
