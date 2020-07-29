package task3_looping_statements;

import java.util.Scanner;

public class Q9_right_angle_triangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num = sc.nextInt();
        String str = "";
        for (int i=1;i<=num;i++){
            str = str+i;
            System.out.println(str);
        }
    }
}
