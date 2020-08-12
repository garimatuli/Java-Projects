// Program to check the number is Armstrong number

/*A positive number is called armstrong number if it is equal to the sum of cubes of its digits
for example 0, 1, 153, 370, 371, 407 etc.
153 = 1*1*1 + 5*5*5 + 3*3*3  // 153 is an Armstrong number
*/

package tasks.task7;

import java.util.Scanner;

public class Q6_ArmstrongNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num = sc.nextInt();
        checkArmstrong(num); // to check a number is Armstrong number or not
    }

    static void checkArmstrong(int num) {
        int sum = 0 , temp;
        int originalNum = num;
        while(num>0)
        {
            temp = num % 10; // extract single digit one by one
            num = num / 10;
            sum = sum + (temp*temp*temp); // cube the digit & add it to previous sum
        }
        if( sum == originalNum)
            System.out.println(originalNum + " is an Armstrong number");
        else
            System.out.println(originalNum + " is not an Armstrong number");
    }
}
