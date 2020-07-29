/*Write a program in JAVA to break and continue if the following cases occur:
●	If the user enters a negative number just break the loop and print “It’s Over”
●	If the user enters a positive number just continue in the loop and print “Good Going”
*/
package task2;

import java.util.Scanner;

public class BreakContinue {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("Enter a number: ");
            int num = sc.nextInt();
            if (num>=0)
            {
                System.out.println("Good Going");
            }
            else {
                System.out.println("It’s Over");
                break;
            }
        }
    }
}
