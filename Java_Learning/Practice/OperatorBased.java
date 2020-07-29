/* Write a program in JAVA to perform the following operator based task:
●	Ask the user to choose the following option first:
○	If User Enter 1 - Addition
○	If User Enter 2 - Subtraction
○	If User Enter 3 - Division
○	If User Enter 4 - Multiplication
○	If User Enter 5 - Average
●	Ask the user to enter the 2 numbers in a variable for first and second(first and second are variable names) for the first 4 options mentioned above and print the result.
●	Ask the user to enter two more numbers as first1 and second2 for calculating the average as soon as the user chooses an option 5.
●	In the end, if the answer of any operation is Negative print a statement saying “Oops option X(1/2/3/4/5/) is returning the negative number”
●	NOTE: At a time users can perform one action at a time.
*/

package task2;

import java.util.Scanner;

public class OperatorBased {
    public static void main(String args[]){
        performOperations();
    }
    public static void performOperations(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose an option from 1 to 5: ");
        System.out.println("1 - Addition \n2 - Subtraction \n3 - Division \n4 - Multiplication \n5 - Average\n");
        int option = sc.nextInt();
        System.out.println("Enter 2 numbers: ");
        double first = sc.nextDouble();
        double second = sc.nextDouble();
        double result = 0;
        switch (option){
            case 1:
                result = first + second;
                break;
            case 2:
                result = first - second;
                break;
            case 3:
                result = first / second;
                break;
            case 4:
                result = first * second;
                break;
            case 5:
                System.out.println("Enter 2 more numbers: ");
                int first1 = sc.nextInt();
                int second2 = sc.nextInt();
                result = (first+second+first1+second2)/4;
                break;
            default:
                System.out.println("Please choose an option among 1 to 5 only!!");
                performOperations();
        }
        if (result < 0){
            System.out.println("Oops option"+option+" is returning the negative number");
        }
        else{
            System.out.println(result);
        }
    }
}
