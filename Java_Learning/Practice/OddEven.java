/* Given an integer, perform the following conditional actions:
●	If  is odd, print NEW
●	If  is even and in the inclusive range of 2 to 5, print OLD
●	If  is even and in the inclusive range of 6 to 30, print NEW
●	If  is even and greater than 30, print OLD
*/
package task2;

import java.util.Scanner;

public class OddEven {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an integer: ");
        int num = sc.nextInt();
        if (num%2!=0){
            System.out.println("NEW");
        }
        else {
            if(num>=2 && num<=5){
                System.out.println("OLD");
            }
            else if (num>=6 && num<=30){
                System.out.println("NEW");
            }
            else {
                System.out.println("OLD");
            }
        }
    }
}
