package task3_looping_statements;

import java.util.Scanner;

public class Q11_floating_point {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input first floating-point number: ");
        double num1 = sc.nextDouble();
        System.out.print("Input second floating-point number: ");
        double num2 = sc.nextDouble();

        num1 = Math.round(num1*100);
        num1 = num1/100;
        num2 = Math.round(num2*100);
        num2 = num2/100;

        if (num1 == num2){
            System.out.println("Numbers are same upto two decimal places");
        }
        else {
            System.out.println("Numbers are different");
        }
    }
}
