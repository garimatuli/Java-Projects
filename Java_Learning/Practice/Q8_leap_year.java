/*a Java program that takes a year from user and print whether that year is a leap year or not.
* An year is a leap year if its divisible by 400 OR
* if it is not divisible by 100 but it is divisible by 4.
* A leap year has 366 days otherwise an year has 365 days.
* 1700, 1800, 1900, 2100, 2200, 2300, 2500, 2600 are not leap years because they are evenly divisible by 100 but not by 400.
* These are leap years: 1600, 2000, 2400 because they are evenly divisible by both 100 and 400.*/
package task3_looping_statements;

import java.util.Scanner;

public class Q8_leap_year {
    public static void main(String[] args)
    {
        int year;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an Year:");
        year = sc.nextInt();
        if((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0)))
            System.out.println("Year " + year + " is a leap year");
        else
            System.out.println("Year " + year + " is not a leap year");
    }
}
