// print multiplication table of a certain number taken from user,
package task3_looping_statements;

import java.util.Scanner;

public class Q1_multiplication_table {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num = sc.nextInt();
        multiplication(num);
    }
    private static void multiplication(int num) {
        for (int i=1; i<=10;i++){
            System.out.println(num+" x "+i+" = "+(num*i));
        }
    }
}
