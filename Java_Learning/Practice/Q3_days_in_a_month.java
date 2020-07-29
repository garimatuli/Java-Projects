/*that takes user input from 1 to 12 for months, and display number of days of a particular month.
(Shows “Invalid Details“ if incorrect month number will be provided).*/
package task3_looping_statements;

import java.util.Scanner;

public class Q3_days_in_a_month {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter month's number: ");
        int month;
        month = sc.nextInt();
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.println("Number of days: 31");
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.println("Number of days: 30");
                break;
            case 2:
                System.out.println("Number of days: 28");
                break;
            default:
                System.out.println("Invalid Details");
                break;
        }
    }
}
