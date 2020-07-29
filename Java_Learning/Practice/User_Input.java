package July22;

import java.util.Scanner;

public class Task_3 {
    public static void main(String args[]){
        calculate();
    }

    public static void calculate(){
        Scanner sc = new Scanner(System.in);
        // Ask the user to enter any 2 numbers in between 1-10
        System.out.println("Enter any 2 numbers in between 1-10: ");
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        if (num1 >= 1 && num1 <= 10 && num2 >= 1 && num2 <= 10) {
            int z = num1 + num2;
            z += 30;
            int results = z;
            System.out.println("Result = "+results);
        } else {
            System.out.println("Both numbers should be in range 1-10.\n");
            calculate();
        }
    }
}
